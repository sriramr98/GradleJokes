package com.sriram.jokeview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class JokeActivity extends AppCompatActivity {

    private static final String TAG = "JokeActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView tv_jokes = findViewById(R.id.tv_joke);

        Intent i = getIntent();

        if (!(i.hasExtra(Constants.JOKE))){
            Toast.makeText(this, "No joke is passed on... ", Toast.LENGTH_SHORT).show();
            Log.e(TAG,"Didn't get any joke through intent extras");
            finish();
            return;
        }


        String joke = i.getStringExtra(Constants.JOKE);

        tv_jokes.setText(joke);

    }
}
