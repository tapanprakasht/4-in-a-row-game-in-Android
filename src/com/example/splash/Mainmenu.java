package com.example.splash;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Mainmenu extends Activity{
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.mainmenu);
		ListView menuList=(ListView) findViewById(R.id.listView1);
		String items[]={getResources().getString(R.string.play),
				getResources().getString(R.string.credit),
				getResources().getString(R.string.help),
				getResources().getString(R.string.exit),
				};
		ArrayAdapter<String> adapter=new ArrayAdapter<String>(this,R.layout.menu_item,items);
		menuList.setAdapter(adapter);
		menuList.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View itemClicked, int position,long id) {
				// TODO Auto-generated method stub
				
				TextView textview=(TextView) itemClicked;
				String strText=textview.getText().toString();
				if(strText.equalsIgnoreCase(getResources().getString(R.string.play)))
				{
					startActivity(new Intent(Mainmenu.this,GameStart.class));
					
				}
				else if(strText.equalsIgnoreCase(getResources().getString(R.string.exit)))
						{
							finish();
							System.exit(0);
						}
				
			}
			
		});
		
	}
	
	
	
	

}
