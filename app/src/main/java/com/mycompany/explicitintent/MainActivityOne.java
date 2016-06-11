package com.mycompany.explicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivityOne extends AppCompatActivity {
    EditText input1,input3;
    TextView input2;
    DatePicker pick;
    Calendar calendar= Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input1 = (EditText)findViewById(R.id.edit1);

        input2 = (TextView)findViewById(R.id.text3);

        pick = (DatePicker)findViewById(R.id.datePicker);

        input3 = (EditText)findViewById(R.id.edit2);


        Button button1=(Button)findViewById(R.id.Button01);

        if(button1!=null) {


            button1.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {

                    input2.setText(getdate());

                    String input_1= input1.getText().toString();
                    String input_2= input2.getText().toString();
                    String input_i = input3.getText().toString();



                    if(TextUtils.isEmpty(input_1.trim()) || TextUtils.isEmpty(input_i.trim()) )
                    {
                        Toast.makeText(getApplicationContext(), "Please fill in all the input fields!!", Toast.LENGTH_SHORT).show();
                    }


                    else if (!(input_1.matches("[a-zA-Z. ]+")))
                    {

                        Toast.makeText(getApplicationContext(), "Name must not contain numbers or any special characters!!\nIt must contain Only LETTERS A FULL STOP AND WHITESPACE", Toast.LENGTH_SHORT).show();
                    }

                    else if(!input_i.equals(crctage())){
                        Toast.makeText(getApplicationContext(), "Please enter the correct age your right age is:"+crctage(), Toast.LENGTH_SHORT).show();
                    }

                    else {
                        //int input_3 =Integer.parseInt(input_i);

                        Intent i = new Intent(getApplicationContext(), MainActivityTwo.class);
                        i.putExtra("Value1",input_1);
                        i.putExtra("Value2", input_2);
                        i.putExtra("Value3",input_i);
                        // Set the request code to any code you like, you can identify the
                        // callback via this code
                        startActivity(i);
                    }


                }
            });

        }

    }

        public String getdate(){
            StringBuilder date=new StringBuilder();

            date.append(pick.getDayOfMonth()).append("/");
            date.append(pick.getMonth()+1).append("/");
            date.append(pick.getYear());
            return date.toString();

        }

        public int getyear(){
            return pick.getYear();
        }


    public int getmonth(){
        return (pick.getMonth()+1);
    }


    public int getday(){
        return pick.getDayOfMonth();
    }




    String crctage()
    {
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH)+1;
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        int usr_year=getyear();
        int usr_month=getmonth();
        int usr_day = getday();


        if(month>usr_month) {
            int ans = year - usr_year;
            return Integer.toString(ans);
        }

        else if(month==usr_month){

            if(day>=usr_day){
                int ans = year - usr_year;
                return Integer.toString(ans);
            }
            else{
                int ans = year-usr_year-1;
                return Integer.toString(ans);
            }
        }

        else {
            int ans= year - usr_year-1;
            return Integer.toString(ans);
        }
    }


}

