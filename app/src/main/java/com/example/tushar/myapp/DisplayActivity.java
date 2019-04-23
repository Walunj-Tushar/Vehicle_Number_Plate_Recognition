package com.example.tushar.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayActivity extends AppCompatActivity
{

    private static TextView txtView;
    public static Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        btnReg = (Button) findViewById(R.id.ID_DONE);

        btnReg.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(DisplayActivity.this, RatingActivity.class);
                startActivity(intent);
            }
        });

        SharedPreferences sobj = getSharedPreferences("VehicleRecognition", Context.MODE_PRIVATE);

        String name = sobj.getString("name",null);
        txtView = (TextView)findViewById(R.id.ID_TextView2);
        txtView.setText(name);

        name = sobj.getString("addr",null);
        txtView = (TextView)findViewById(R.id.ID_TextView4);
        txtView.setText(name);

        name = sobj.getString("phoneNumber",null);
        txtView = (TextView)findViewById(R.id.ID_TextView6);
        txtView.setText(name);

        name = sobj.getString("email",null);
        txtView = (TextView)findViewById(R.id.ID_TextView8);
        txtView.setText(name);

        name = sobj.getString("number",null);
        txtView = (TextView)findViewById(R.id.ID_TextView10);
        txtView.setText(name);


    }
}
