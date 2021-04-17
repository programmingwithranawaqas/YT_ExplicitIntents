package com.example.yt_explicitintents;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etFirstname;
    Button btnSubmit, btnGetLastName;
    TextView tvLastName;
    final int THIRD_ACTIVITY = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = etFirstname.getText().toString().trim();
                if(firstname.isEmpty())
                {
                    etFirstname.setError("name is empty");
                }
                else
                {
                    Intent intent = new Intent(MainActivity.this, com.example.yt_explicitintents.SecondActivity.class);
                    intent.putExtra("fname", firstname);
                    intent.putExtra("day",17);
                    startActivity(intent);
                    finish();
                }
            }
        });

        btnGetLastName.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ThirdActivity.class);
                startActivityForResult(intent, THIRD_ACTIVITY);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == THIRD_ACTIVITY)
        {
            if(resultCode == RESULT_CANCELED)
            {
                Toast.makeText(this, "No data entered in Third Activity", Toast.LENGTH_SHORT).show();
            }
            else if(resultCode == RESULT_OK)
            {
                String temp = data.getStringExtra("lastname");
                tvLastName.setText("Your last name is : "+temp);
            }
        }
    }

    private void init() {
        etFirstname = findViewById(R.id.etFirstname);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnGetLastName = findViewById(R.id.btnGetLastName);
        tvLastName = findViewById(R.id.tvLastName);
    }
}