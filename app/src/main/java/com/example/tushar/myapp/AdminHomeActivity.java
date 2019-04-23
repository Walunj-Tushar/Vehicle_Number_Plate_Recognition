package com.example.tushar.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class AdminHomeActivity extends AppCompatActivity
{

    private static String arr[];
    private static Button btnSearch;
    private static Button btnRecord;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adminhome);

        btnSearch = (Button) findViewById(R.id.ID_Search);
        btnRecord = (Button) findViewById(R.id.ID_Record);

        btnSearch.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminHomeActivity.this, SearchActivity.class);
                startActivity(intent);
            }
        });

        btnRecord.setOnClickListener( new Button.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(AdminHomeActivity.this, AdminDisplayActivity.class);
                startActivity(intent);
            }
        });
    }


}
