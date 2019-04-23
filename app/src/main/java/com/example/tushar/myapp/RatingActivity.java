package com.example.tushar.myapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RatingActivity extends AppCompatActivity
{
    private Button bobj;
    private RatingBar robj;
    private TextView tobj;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rating);

        OnButtonClick();
        OnRatnigBar();
    }

    public void OnButtonClick()
    {
        bobj = (Button)findViewById(R.id.ID_BUTTON);
        robj = (RatingBar)findViewById(R.id.ID_RATING);

        bobj.setOnClickListener(
                new View.OnClickListener()
                {
                    @Override
                    public void onClick(View v)
                    {
                        Toast.makeText(RatingActivity.this,"Rating is : "+String.valueOf(robj.getRating()),Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(RatingActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );

    }

    public void OnRatnigBar()
    {
        robj = (RatingBar)findViewById(R.id.ID_RATING);

        robj.setOnRatingBarChangeListener(
                new RatingBar.OnRatingBarChangeListener()
                {
                    @Override
                    public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser)
                    {
                        Toast.makeText(RatingActivity.this,"Thank you!! your rating is : "+String.valueOf(rating),Toast.LENGTH_SHORT).show();
                    }
                }
        );

    }
}
