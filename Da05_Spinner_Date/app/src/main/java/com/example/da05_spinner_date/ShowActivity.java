package com.example.da05_spinner_date;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ShowActivity extends AppCompatActivity {

    private TextView txtBirthDay, txtNationality;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        txtBirthDay = findViewById(R.id.txtBirthDay);
        txtNationality = findViewById(R.id.txtNationality);

        Intent intent = this.getIntent();
        Bundle bundle = intent.getBundleExtra("INFO");
        txtNationality.setText("Nationality: " + bundle.getString("nationality"));
        txtBirthDay.setText("Birthday: " + bundle.getString("birthday"));

    }
}
