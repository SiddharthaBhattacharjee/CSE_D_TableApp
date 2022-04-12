package com.example.timetable;


import androidx.appcompat.app.AppCompatActivity;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.sql.Date;

import java.text.SimpleDateFormat;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Handler mHandler;
    TextView dateTimeDisplay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dateTimeDisplay = findViewById(R.id.textView62);
        String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
        dateTimeDisplay.setText("DATE : "+currentDate+"\nTIME : "+currentTime);
        this.mHandler = new Handler();
        m_Runnable.run();
    }
    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            String currentDate = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            String currentTime = new SimpleDateFormat("HH:mm", Locale.getDefault()).format(new Date(System.currentTimeMillis()));
            dateTimeDisplay.setText("DATE : "+currentDate+"\nTIME : "+currentTime);

            MainActivity.this.mHandler.postDelayed(m_Runnable,20000);
        }

    };

    public void onClickTT(View view){
        Intent i = new Intent(this,MainActivity2.class);
        startActivity(i);
    }
    public void onClickFD(View view){
        Intent i = new Intent(this,MainActivity3.class);
        startActivity(i);
    }
}