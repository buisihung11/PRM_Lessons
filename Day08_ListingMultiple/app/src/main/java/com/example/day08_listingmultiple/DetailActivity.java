package com.example.day08_listingmultiple;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {
    private TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = getIntent();
        txtResult.setText(intent.getStringExtra("test"));
    }
}
