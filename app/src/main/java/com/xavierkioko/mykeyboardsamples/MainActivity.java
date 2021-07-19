
package com.xavierkioko.mykeyboardsamples;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.Calendar;

//1.Implement an interface (view.onclicklistener)which allows us to handle on click events on our calender picker dialog
//7.0 Implement an interface (Adapterview.onitemselected listener)
public class MainActivity extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    //2.declare an edittext variable that is the focus on the calender dialog
    private EditText birthday;
    //5.declare the variables to hold the selected date(year month and day)
    private int mYear;
    private int mMonth;
    private int mDay;
    //7.6 Declare a variable for holding the item selected on the spinner
    private String mSpinnerLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //3.connect the edittext variable you created with the one specified in the layout for receiving the date value
        birthday=findViewById(R.id.birthday);
        //4.Connect the edittext variable with an onclick listener
        birthday.setOnClickListener(this);
        //7.1Declare a spinner variable and connect it with a spinner view in the layout
        Spinner phoneSpinner =findViewById(R.id.phone_spinner);
        //7.2 Set an itemselectedlistener on the spinner object/variable you have created
        if (phoneSpinner!=null){
            phoneSpinner.setOnItemSelectedListener(this);
        }
        //7.3Create an array adapterusing the string array and default spinner layout
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.spinner_label, android.R.layout.simple_spinner_item);
        //7.4 Specify the layout for the drop downmenu
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //7.5 Attach the spinner to the adapter
        if(phoneSpinner!=null) {
            phoneSpinner.setAdapter(adapter);
        }


    }

    @Override
    public void onClick(View v) {
        //6.To get the instance of the current date
        //6.1 Ensure the focus is on the edit text variable birthday
        if (v==birthday){
            //6.2declare a calender to get current selected date
            final Calendar c =Calendar.getInstance();
            mYear=c.get(Calendar.YEAR);
            mMonth=c.get(Calendar.MONTH);
            mDay=c.get(Calendar.DAY_OF_MONTH);

            //6.3 declare a datepicker dialog to pick selected date
            DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    //6.4 set the date on the edittext variable
                    birthday.setText(dayOfMonth +"-"+(month+1+"-"+year));

                }
            },mYear,mMonth,mDay);
            //6.5 show the date picker dialog.
            datePickerDialog.show();

        }

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //7.6 Declare a variable for holding the item selected on the spinner
        //7.7 Use the method Get item at position () to get the label selected
        mSpinnerLabel=adapterView.getItemAtPosition(i).toString();
        //7.8 Something to do with item selected
        Toast myToast=Toast.makeText(this,"Selected phone as:" +mSpinnerLabel,Toast.LENGTH_SHORT);
        myToast.show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        //7.9 Something to do
        Toast toast=Toast.makeText(this,"nothing selected",Toast.LENGTH_SHORT);
        toast.show();

    }

    public void showToast(View view) {
        Toast check = Toast.makeText(this,"Please Accept Terms and conditions",Toast.LENGTH_SHORT);
        check.show();
    }

    public void createAccount(View view) {
        //compare passwords
        //Throw error exemptions
        //get the data entered on edit text and save it on a database
        //Add an intent and open main Activity/login Activity
        //Throw a a toast
        Toast toastSubmit =Toast.makeText(this,"Account Creation Successful",Toast.LENGTH_SHORT);
        toastSubmit.show();

    }
}