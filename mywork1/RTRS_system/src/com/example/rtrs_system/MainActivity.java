package com.example.rtrs_system;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void funcreserve(View v)
    {
    	Intent intent=new Intent(this,Reservation.class);
    	startActivity(intent);
    }
}
