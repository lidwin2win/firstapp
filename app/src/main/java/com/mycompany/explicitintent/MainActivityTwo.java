package com.mycompany.explicitintent;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivityTwo extends AppCompatActivity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_second);
        TextView tv=new TextView(this);
        tv.setText("second activity");


        TextView tv1 = (TextView)findViewById(R.id.textView1);
        TextView tv2 = (TextView)findViewById(R.id.textView2);
        TextView tv3 = (TextView)findViewById(R.id.textView3);



        Bundle extras = getIntent().getExtras();
        String value1 = extras.getString("Value1");
        String value2 = extras.getString("Value2");
        String value3 = extras.getString("Value3");


            tv1.setText(value1);
            tv2.setText(value2);
            tv3.setText(value3);




      //  Toast.makeText(getApplicationContext(),"Values are:\n First value: "+value1+
        //        "\n Second Value: "+value2, Toast.LENGTH_LONG).show();


    }
}