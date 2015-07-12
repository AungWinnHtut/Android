package com.example.androidsoap;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
 
import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.view.Menu;
import android.widget.TextView;
 
public class MainActivity extends Activity {
 
   private final String NAMESPACE = "http://sandep.byethost32.com/soap/demourn:demo";
   private final String URL = "http://sandep.byethost32.com/demo/service.php?wsdl";
   private final String SOAP_ACTION = "http://sandep.byethost32.com/soap/demourn:demo/price";
   private final String METHOD_NAME = "price";
    
   private String webResponse = "";
   private TextView textView;
   private Thread thread;
   private Handler handler = new Handler();
    
   private String fromCurrency = "xyz";
   private String toCurrency = "LKR";
    
    /** Called when the activity is first created. */
  
 @Override
 protected void onCreate(Bundle savedInstanceState) {
  super.onCreate(savedInstanceState);
  setContentView(R.layout.activity_main);
  textView = (TextView) findViewById(R.id.textView1);
  startWebAccess();
 }
  
  
 public void startWebAccess(){
  thread = new Thread(){
   public void run(){
    try{
      SoapObject request = new SoapObject(NAMESPACE, METHOD_NAME); 
         PropertyInfo fromProp =new PropertyInfo();
         fromProp.setName("name");
         fromProp.setValue(fromCurrency);
         fromProp.setType(String.class);
         request.addProperty(fromProp);
               
                      
         SoapSerializationEnvelope envelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
         envelope.dotNet = true;
         envelope.setOutputSoapObject(request);
         HttpTransportSE androidHttpTransport = new HttpTransportSE(URL);
             
         androidHttpTransport.call(SOAP_ACTION, envelope);
         SoapPrimitive response = (SoapPrimitive)envelope.getResponse();
         webResponse = response.toString();
    }
     
    catch(Exception e){
     e.printStackTrace();
    }
     
    handler.post(createUI);
   }
  };
   
  thread.start();
 }
  
  
 final Runnable createUI = new Runnable() {
 
  public void run(){
 
  textView.setText("1 "+fromCurrency+" = "+webResponse+" ");
  }
  };
 
 
  
 @Override
 public boolean onCreateOptionsMenu(Menu menu) {
  // Inflate the menu; this adds items to the action bar if it is present.
  getMenuInflater().inflate(R.menu.main, menu);
  return true;
 }
 
}