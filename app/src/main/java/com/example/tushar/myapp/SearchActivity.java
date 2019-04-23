package com.example.tushar.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class SearchActivity extends AppCompatActivity
{

    public static int icnt = 3;
    private Button btn;
    private TextView txtInputpin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search);



         btn = (Button) findViewById(R.id.ID_Confirm);
        btn.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                 txtInputpin = (TextView)findViewById(R.id.ID_Number);

                int inputPin = Integer.parseInt(txtInputpin.getText().toString());

                if(txtInputpin.length()!=4) {
                    Toast.makeText(getApplicationContext(), "Give Valid Number", Toast.LENGTH_LONG).show();
                }
                else {
                    Intent intent = new Intent(SearchActivity.this, AdminDisplayActivity.class);
                    startActivity(intent);
                }
            }
        });

       /* btn.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                SharedPreferences sobj = getSharedPreferences("VehicleRecognition", Context.MODE_PRIVATE);
                int pin = sobj.getInt("number",0);


                TextView txtInputpin = (TextView)findViewById(R.id.ID_Number);

                int inputPin = Integer.parseInt(txtInputpin.getText().toString());
                int inputPin1 = Integer.parseInt(txtInputpin.getText().toString());

                if( inputPin < 0)
                {
                    Toast.makeText(getApplicationContext(), "Give Valid Data ", Toast.LENGTH_LONG).show();
                }
                else
                {
                    if (inputPin !=0) {
                        Intent intent = new Intent(SearchActivity.this, com.example.tushar.myapp.AdminDisplayActivity.class);
                        startActivity(intent);
                    } else {

                        Toast.makeText(getApplicationContext(), "Invalid Number ", Toast.LENGTH_LONG).show();
                        icnt--;
                        if (icnt == 0)
                        {
                            Toast.makeText(getApplicationContext(), " Search Again ", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(SearchActivity.this, AdminHomeActivity.class);
                            startActivity(intent);
                        }
                    }

                }

            }
        });*/


    }
}
