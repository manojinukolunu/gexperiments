package com.badlogic.andriodgames;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.game1exp.R;

public class AndroidBasicsStarter extends ListActivity {

	String[] activitiesList = { "KeyTest1","ExternalStorage" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,activitiesList));
	}

	protected void onListItemClick(ListView list, View view, int position,
			long id) {
		super.onListItemClick(list, view, position, id);
		String testName = activitiesList[position];
		try {
			Class clazz = Class.forName("com.badlogic.andriodgames." + testName);
			Intent intent = new Intent(this, clazz);
			startActivity(intent);

		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

	}

}
