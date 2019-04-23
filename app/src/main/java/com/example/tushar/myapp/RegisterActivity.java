package com.example.tushar.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class RegisterActivity extends AppCompatActivity
{
    private static final int READ_SMS_PERMISSIONS_REQUEST = 1;

    private static Button btnVerify;
    private  static EditText txtPhoneNo;
    private  static EditText txtName;
    public static EditText txtAddr;
    private  static EditText txtNumber;
    private static EditText txtEmail;

    public static String phoneNo;
    private  static String message;
    public  static String name;
    public  static String number;
    public  static String addr;
    public static int SelectedCourseIndex;
    public static int OPTpin;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        btnVerify = (Button) findViewById(R.id.ID_Verify);
        txtName = (EditText) findViewById(R.id.ID_Name);
        txtPhoneNo = (EditText) findViewById(R.id.ID_PhoneNumber);
        txtEmail = (EditText) findViewById(R.id.ID_Email);
        txtAddr = (EditText) findViewById(R.id.ID_Addr);
        txtNumber = (EditText) findViewById(R.id.ID_Number);


        final ArrayAdapter<String> CourseAdapter = new ArrayAdapter<String>(RegisterActivity.this,
                android.R.layout.simple_list_item_1,
                getResources().getStringArray(R.array.courses));


            String[] CoursesArray = getResources().getStringArray(R.array.courses);
            String[] CoursesAmount = getResources().getStringArray(R.array.course_amount);

        btnVerify.setOnClickListener(new Button.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Random r = new Random();
                OPTpin = (r.nextInt() % 10000);
                while (OPTpin < 1000)
                    OPTpin = (r.nextInt() % 10000);

                setData();
                Toast.makeText(getApplicationContext(), OPTpin +"", Toast.LENGTH_LONG).show();
            }
        });
    }

    void setData()
    {
        name = txtName.getText().toString();
        addr = txtAddr.getText().toString();
        phoneNo = txtPhoneNo.getText().toString();
        number = txtNumber.getText().toString();
        String email = txtEmail.getText().toString();

        if( (name.length() == 0 ) || (phoneNo.length() != 10)|| (number.length() != 4) || (email.length() != 12) )
        {
            Toast.makeText(getApplicationContext(), "Give Valid Data", Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Thank you for providing information.", Toast.LENGTH_LONG).show();

            SharedPreferences sobj = getSharedPreferences("VehicleRecognition", Context.MODE_PRIVATE);

            SharedPreferences.Editor editobj = sobj.edit();

            editobj.putString("name", name);
            editobj.putString("addr", addr);
            editobj.putString("phoneNumber", phoneNo);
            editobj.putString("number", number);
            editobj.putString("email", email);
            editobj.putInt("OPTpin", OPTpin);

            editobj.apply();

            sendVerificationPin();
        }

    }

    void sendVerificationPin()
    {
        phoneNo = txtPhoneNo.getText().toString();

        name = txtName.getText().toString();

        message = "Dear " + name + ", Thank you for Registering  Your Pin code is " + OPTpin;
        try
        {

                Intent intent = new Intent(RegisterActivity.this, com.example.tushar.myapp.OPTcheckingActivity.class);
                startActivity(intent);

        }
        catch(Exception e)
        {
            Toast.makeText(getApplicationContext(),
                    "Give permission of message",
                    Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           @NonNull String permissions[],
                                           @NonNull int[] grantResults)
    {
        if (requestCode == READ_SMS_PERMISSIONS_REQUEST)
        {
            if (grantResults.length == 1 &&
                    grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                Toast.makeText(this, "Send SMS permission granted", Toast.LENGTH_SHORT).show();

            }
            else
            {
                Toast.makeText(this, "Send SMS permission denied", Toast.LENGTH_SHORT).show();
            }
        }
        else
        {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }

}
