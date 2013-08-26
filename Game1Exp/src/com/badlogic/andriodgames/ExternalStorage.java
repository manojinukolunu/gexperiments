package com.badlogic.andriodgames;

import java.io.File;
import java.util.ArrayList;

import android.app.ListActivity;
import android.os.Bundle;
import android.os.Environment;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class ExternalStorage extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		TextView textView = new TextView(this);
//		setContentView(textView);
		
		String state = Environment.getExternalStorageState();
		if(!state.equals(Environment.MEDIA_MOUNTED)){
			textView.setText("No External Storage Mounted fail!!!");
		}
		
		else{
			StringBuffer b = new StringBuffer();
			File externalDir = Environment.getExternalStorageDirectory();
			ArrayList files = new ArrayList();
			for(File f : externalDir.listFiles()){
				b.append(f.getAbsolutePath()+"/n");
				files.add(f.getAbsolutePath());
			}
			String [] stockArr = (String[]) files.toArray(new String[0]); 
			textView.setText(b.toString());
			setListAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,stockArr));
		}
		
		
	}

	

}
