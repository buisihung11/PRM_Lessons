package com.example.day03_progressdialog_sms;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SendSMSActivity extends AppCompatActivity {
    private EditText edtPhone, edtContent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_s_m_s);
        edtPhone = findViewById(R.id.txtPhone);
        edtContent = findViewById(R.id.txtContent);
    }

    public void clickToSend(View view) {
        String phone = edtPhone.getText().toString();
        String content = edtContent.getText().toString();
        final SmsManager smsManager = SmsManager.getDefault();
        Intent intent = new Intent("HungBS_Send_SMS");
        PendingIntent pendingIntent = PendingIntent.getBroadcast(this, 0, intent, 0);
        registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                int result = getResultCode();
                String msg = "Send OK";
                if(result != Activity.RESULT_OK){
                    msg = "Send Fail";
                }
                Toast.makeText(SendSMSActivity.this, msg, Toast.LENGTH_LONG).show();
            }
        }, new IntentFilter("HungBS_Send_SMS"));
        smsManager.sendTextMessage(phone,null,content,pendingIntent,null);
        finish();
    }
}
