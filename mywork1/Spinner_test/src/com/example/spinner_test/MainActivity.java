package app.test;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class Test extends Activity {
  String[] presidents;

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.main);

    presidents = getResources().getStringArray(R.array.presidents_array);
    Spinner s1 = (Spinner) findViewById(R.id.spinner1);

    ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        android.R.layout.simple_spinner_dropdown_item, presidents);

    s1.setAdapter(adapter);
    s1.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> arg0, View arg1,
          int arg2, long arg3) {
        int index = arg0.getSelectedItemPosition();
        Toast.makeText(getBaseContext(),
            "You have selected item : " + presidents[index],
            Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onNothingSelected(AdapterView<?> arg0) {
      }
    });
  }
}