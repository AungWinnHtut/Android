package com.example.exercisebook1;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class EX_1 extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ex_1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_ex_1, menu);
        return true;
    }
}
