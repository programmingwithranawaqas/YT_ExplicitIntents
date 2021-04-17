package com.example.yt_explicitintents;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvUsername;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        tvUsername = findViewById(R.id.tvUsername);

        Intent i = getIntent();
        String name = i.getStringExtra("fname");

        tvUsername.setText("Welcome "+name);

    }
}