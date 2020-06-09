package com.example.day02_activity;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InputActivity extends AppCompatActivity {

    private EditText editUsername, editPhone, editEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input);
        editEmail = findViewById(R.id.editEmail);
        editPhone = findViewById(R.id.editPhone);
        editUsername = findViewById(R.id.editUsername);
    }


    public void clickToDone(View view) {
        String username = editUsername.getText().toString();
        String mail = editEmail.getText().toString();
        String phone = editPhone.getText().toString();

//        Intent intent = new Intent(this, MainActivity.class);
        Intent intent = this.getIntent();
        intent.putExtra("username", username);
        intent.putExtra("phone", phone);
        intent.putExtra("email", mail);
//        startActivity(intent);
        this.setResult(RESULT_OK,intent);
        finish();
    }
}
