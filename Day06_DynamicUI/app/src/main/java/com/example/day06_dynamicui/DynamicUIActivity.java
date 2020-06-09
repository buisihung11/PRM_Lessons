package com.example.day06_dynamicui;

import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DynamicUIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.WRAP_CONTENT);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);

        TextView txtUsername = new TextView(this);
        txtUsername.setText("Username: ");
        txtUsername.setLayoutParams(params);

        TextView txtEmail = new TextView(this);
        txtEmail.setText("Email: ");
        txtEmail.setLayoutParams(params);

        final EditText edtUsername = new EditText(this);
        edtUsername.setLayoutParams(params);
        edtUsername.setId(R.id.edtUsername);

        final EditText edtEmail = new EditText(this);
        edtEmail.setLayoutParams(params);
        edtEmail.setId(R.id.edtEmail);

        Button btn = new Button(this);
        btn.setText("DONE");
        btn.setLayoutParams(params);

        layout.addView(txtUsername);
        layout.addView(txtEmail);
        layout.addView(edtUsername);
        layout.addView(edtEmail);
        layout.addView(btn);

        this.addContentView(layout, params);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast t = Toast.makeText(DynamicUIActivity.this
                        , edtUsername.getText().toString() + " " + edtEmail.getText().toString()
                        , Toast.LENGTH_LONG);
                t.setGravity(Gravity.TOP, 10, 10);
                t.show();
            }
        });
    }
}
