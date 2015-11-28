# Introduction

# Usage
1.Replace standard ListView with com.huang.views.indexListview.IndexListView in your layout.xml file.
~~~xml
<com.huang.views.indexListview.IndexListView
        android:id="@+id/my_listView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        >
    </com.huang.views.indexListview.IndexListView>
~~~

2.use IndexListViewAdapter to set adapter 
~~~java
		myIndexListView = (IndexListView) findViewById(R.id.my_listView);
		ArrayAdapter<String>  adapter = new IndexListViewAdapter(this, android.R.layout.simple_list_item_1, yourList);
		myIndexListView.setAdapter(adapter);
		~~~
