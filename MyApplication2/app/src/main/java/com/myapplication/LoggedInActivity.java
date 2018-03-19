package com.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static android.transition.Fade.IN;

public class LoggedInActivity extends AppCompatActivity {

    private TextView text;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        text = (TextView) findViewById(R.id.Textview_id);
        Intent intent = getIntent();
        String username = intent.getStringExtra("Username");

        text.setText("Welcome " + username);

    }
}
