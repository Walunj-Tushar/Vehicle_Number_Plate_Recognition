package com.example.tushar.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button btn = (Button) findViewById(R.id.ID_Welcome);

        btn.setOnClickListener( new Button.OnClickListener(){
            @Override
            public void onClick(View view)
            {
                Toast.makeText(getApplicationContext(),"Welcome",Toast.LENGTH_LONG).show();
            }
        });


        new Handler().postDelayed(new Runnable()
        {
            @Override
            public void run()
            {
                Intent startActivity = new Intent(MainActivity.this, com.example.tushar.myapp.HomeActivity.class);
                startActivity(startActivity);
                finish();
            }
        }, 5000);

    }
}
