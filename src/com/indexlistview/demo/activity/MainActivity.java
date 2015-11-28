package com.indexlistview.demo.activity;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.indexlistview.demo.activity.R;
import com.huang.views.indexListview.IndexListView;
import com.huang.views.indexListview.IndexListViewAdapter;

public class MainActivity extends ActionBarActivity
{

	IndexListView myIndexListView;
	ArrayAdapter<String> adapter;
	List<String> contactsList = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		myIndexListView = (IndexListView) findViewById(R.id.my_listView);
		readContacts();
		adapter = new IndexListViewAdapter(this, android.R.layout.simple_list_item_1, contactsList);
		myIndexListView.setAdapter(adapter);

	}
	/**
	 * ����ֻ�ͨѶ¼��myIndexListView��
	 * ��Ҫע�� uses-permission
	 */
	private void readContacts()
	{
		Cursor cursor = null;
		try
		{
			cursor = getContentResolver().query(ContactsContract.CommonDataKinds.Phone.CONTENT_URI, null, null, null, null);
			while(cursor.moveToNext())
			{
				String displayName = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.DISPLAY_NAME));
				String number = cursor.getString(cursor.getColumnIndex(ContactsContract.CommonDataKinds.Phone.NUMBER));
				
				contactsList.add(displayName.trim());
			
			}
			Collections.sort(contactsList, Collator.getInstance(Locale.CHINA));//���������� δ���������
		} catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(cursor != null)
			{
				cursor.close();
				
			}
		}
		
	}
	

}
