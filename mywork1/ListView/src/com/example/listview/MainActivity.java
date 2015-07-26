package com.example.listview;


import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;
public class MainActivity extends Activity {
    ListView lv;
    String[] str=new String[]{"apple","orange","watermelo","banna"};
    @Override

    
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv=(ListView)(findViewById(R.id.listView1));
        ArrayAdapter<String>adapter=new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1,android.R.id.text1,str);
        lv.setAdapter(adapter);
        lv.setDividerHeight(1);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        
        	public void onItemClick(AdapterView<?> arg0, View arg1, int position,long arg3) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "you click="+position, Toast.LENGTH_SHORT).show();
			}
		});
       
    }
@Override
public boolean onCreateOptionsMenu(Menu menu){

	getMenuInflater().inflate(R.menu.activity_main,menu);
	return super.onCreateOptionsMenu(menu);
	
}
 @Override
 public boolean onOptionsItemSelected(MenuItem item){
	 switch(item.getItemId()){
	 case R.id.menu_settings:
	 Toast.makeText(getApplicationContext(), "You Click=Setting", Toast.LENGTH_LONG).show();
	 break;
	 
	 case R.id.hello:
		 Toast.makeText(getApplicationContext(), "You Click=Hello Developer",Toast.LENGTH_SHORT).show();
		 break;
	 }
	return super.onOptionsItemSelected(item);
	 
 }
    }

