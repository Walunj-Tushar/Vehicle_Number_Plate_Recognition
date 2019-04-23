package com.example.tushar.myapp;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class OPTcheckingActivity extends AppCompatActivity
{

    public static int icnt = 3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_optchecking);

        Button btnValid = (Button) findViewById(R.id.ID_OPTpinValidation);

        btnValid.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                SharedPreferences sobj = getSharedPreferences("VehicleRecognition", Context.MODE_PRIVATE);
                int pin = sobj.getInt("OPTpin",0);


                TextView txtInputpin = (TextView)findViewById(R.id.ID_Number);

                int inputPin = Integer.parseInt(txtInputpin.getText().toString());

                if( inputPin < 0)
                {
                    Toast.makeText(getApplicationContext(), "Give Valid Data ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (pin == inputPin) {
                        Intent intent = new Intent(OPTcheckingActivity.this, com.example.tushar.myapp.DisplayActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(getApplicationContext(), "Invalid Pin ", Toast.LENGTH_LONG).show();
                        icnt--;
                        if (icnt == 0)
                        {
                            Toast.makeText(getApplicationContext(), " Register Again ", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(OPTcheckingActivity.this, RegisterActivity.class);
                            startActivity(intent);
                        }
                    }

                }

            }
        });


    }
}
