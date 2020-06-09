package com.example.day02_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.InputEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView txtResult;
    private static final int REQ_CODE = 117;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("OnCreate");
        setContentView(R.layout.activity_main);
        txtResult = findViewById(R.id.txtResult);
        Intent intent = this.getIntent();
    }

    @Override
    protected void onStart() {
        super.onStart();
        System.out.println("OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("OnResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("OnStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("OnRestart");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_CODE && resultCode == RESULT_OK) {
            String username = data.getStringExtra("username");
            String phone = data.getStringExtra("phone");
            String mail = data.getStringExtra("email");
            if (username != null && phone != null && mail != null) {
                String result = new StringBuilder().append(username).append("\n")
                        .append(phone).append("\n").append(mail).toString();
                txtResult.setText(result);
            }
        }
    }

    public void clickToInput(View view) {
        Intent intent = new Intent(this, InputActivity.class);
//        startActivity(intent);
        startActivityForResult(intent, REQ_CODE);
    }
}
