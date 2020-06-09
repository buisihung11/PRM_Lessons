package com.example.day03_progressdialog_sms;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button btnProgress;
    ProgressDialog myPro_bar;
    Handler hadnler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnProgress = findViewById(R.id.btnProgress);
        btnProgress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myPro_bar = new ProgressDialog(MainActivity.this);
                myPro_bar.setMessage("Loading...🔃");
                myPro_bar.setTitle("Please wait...");
                myPro_bar.setProgressStyle(myPro_bar.STYLE_HORIZONTAL);
                myPro_bar.setProgress(0);
                myPro_bar.setMax(20);
                // Do UIThread xu ly giao dien
                // 1. Thong qua Async Task
                // 2. Gui msg token
                myPro_bar.show();
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            while (myPro_bar.getProgress() < myPro_bar.getMax()){
                                // Handle expensive function here
                                Thread.sleep(1000);
                                hadnler.sendMessage(hadnler.obtainMessage());
                            }
                            if(myPro_bar.getProgress() <= myPro_bar.getMax()){
                                myPro_bar.dismiss();
                            }
                        }catch (Exception e){
                            e.printStackTrace();
                        }
                    }
                }).start();
            }
        });
        hadnler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                super.handleMessage(msg);
                myPro_bar.incrementProgressBy(2);
            }
        };
    }

    public void clickToSms(View view) {
        Intent intent = new Intent(this,SendSMSActivity.class);
        startActivity(intent);
    }
}
