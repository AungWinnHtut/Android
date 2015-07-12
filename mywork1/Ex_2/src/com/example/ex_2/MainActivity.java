package com.example.ex_2;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.Menu;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;

public class MainActivity extends Activity {
public final static String EXTRA_MESSAGE="com.example.ex_2.MESSAGE";
	EditText mEtPwed;
	CheckBox mCbShowPwd;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mEtPwed=(EditText)findViewById(R.id.editText1);
        mCbShowPwd=(CheckBox)findViewById(R.id.checkBox1);      
        mCbShowPwd.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
				// TODO Auto-generated method stub
				if(!isChecked){
					mEtPwed.setTransformationMethod(PasswordTransformationMethod.getInstance());
					
				}
				else{
					mEtPwed.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
				}
			}
		});
    }
    public void sendmessage(View view)
    {
    	Intent intent=new Intent(this,DisplayMesssageActivity.class);
    	String message=mEtPwed.getText().toString();
    	intent.putExtra(EXTRA_MESSAGE, message);
    	startActivity(intent);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
