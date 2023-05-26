package com.example.day2;

import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class SmsApp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_app);
    }

    public void sms(View view) {
        SmsManager sm=SmsManager.getDefault();
        sm.sendTextMessage("6363798024",null,"hii",null,null);
    }
}