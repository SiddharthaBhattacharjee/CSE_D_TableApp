package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;

import android.os.Handler;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TableRow;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class MainActivity2 extends AppCompatActivity {
    TextView dayDisplay;
    TextView s1,s2,s3,s4,s5,s6,s7,s8;
    ImageButton fb,bw;
    TableRow r1,r2,r3,r4,r5,r6,r7,r8,r9,r10;
    Handler mHandler;
    Resources resource;
    int nd;
    String[][] arr = {
            {"APTI","APTI","VE","CHEM","MATHS","PPS","FREE","FREE"},
            {"MATHS","CHEM","FREE","FREE","VAC","VAC","PPS (lab)","PPS (lab)"},
            {"PPS","MATHS","CHEM","VE","LANG","LANG","WS","WS (till 4:30)"},
            {"FREE","PPS","LANG","LANG","CHEM (lab)","CHEM (lab)","WS","WS"},
            {"PPS (lab)","PPS (lab)","FREE","MATHS","NSO","NSO","CHEM","FREE"},
            {"FREE","FREE","FREE","FREE","FREE","FREE","FREE","FREE"},
            {"FREE","FREE","FREE","FREE","FREE","FREE","FREE","FREE"}
    };

    String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        dayDisplay = findViewById(R.id.dayview);
        s1 = findViewById(R.id.sub1);
        s2 = findViewById(R.id.sub2);
        s3 = findViewById(R.id.sub3);
        s4 = findViewById(R.id.sub4);
        s5 = findViewById(R.id.sub5);
        s6 = findViewById(R.id.sub6);
        s7 = findViewById(R.id.sub7);
        s8 = findViewById(R.id.sub8);
        fb = findViewById(R.id.forwbtn);
        bw = findViewById(R.id.backbtn);
        r1 = findViewById(R.id.r1);
        r2 = findViewById(R.id.r2);
        r3 = findViewById(R.id.r3);
        r4 = findViewById(R.id.r4);
        r5 = findViewById(R.id.r5);
        r6 = findViewById(R.id.r6);
        r7 = findViewById(R.id.r7);
        r8 = findViewById(R.id.r8);
        r9 = findViewById(R.id.r9);
        r10 = findViewById(R.id.r10);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                nd=6;
                dayDisplay.setText("SUNDAY");
                break;
            case Calendar.MONDAY:
                nd=0;
                dayDisplay.setText("MONDAY");
                break;
            case Calendar.TUESDAY:
                nd=1;
                dayDisplay.setText("TUESDAY");
                break;
            case Calendar.WEDNESDAY:
                nd=2;
                dayDisplay.setText("WEDNESDAY");
                break;
            case Calendar.THURSDAY:
                nd=3;
                dayDisplay.setText("THURSDAY");
                break;
            case Calendar.FRIDAY:
                nd=4;
                dayDisplay.setText("FRIDAY");
                break;
            case Calendar.SATURDAY:
                nd=5;
                dayDisplay.setText("SATURDAY");
                break;
            default:
                nd=5;
                break;
        }
        s1.setText(arr[nd][0]);
        s2.setText(arr[nd][1]);
        s3.setText(arr[nd][2]);
        s4.setText(arr[nd][3]);
        s5.setText(arr[nd][4]);
        s6.setText(arr[nd][5]);
        s7.setText(arr[nd][6]);
        s8.setText(arr[nd][7]);

        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        int t = hour*60 + minute;
        resource = this.getResources();
        if(t>=480){
            r1.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=530){
            r2.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=580){
            r3.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=590){
            r4.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=640){
            r5.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=690){
            r6.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=740){
            r7.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=790){
            r8.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=840){
            r9.setBackgroundColor(resource.getColor(R.color.hblue));
        }
        if(t>=890){
            r10.setBackgroundColor(resource.getColor(R.color.hblue));
        }



        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nd==6){
                    nd=0;
                }
                else{
                    nd+=1;
                }
                dayDisplay.setText(days[nd]);
                s1.setText(arr[nd][0]);
                s2.setText(arr[nd][1]);
                s3.setText(arr[nd][2]);
                s4.setText(arr[nd][3]);
                s5.setText(arr[nd][4]);
                s6.setText(arr[nd][5]);
                s7.setText(arr[nd][6]);
                s8.setText(arr[nd][7]);

            }
        });

        bw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nd==0){
                    nd=6;
                }
                else{
                    nd -= 1;
                }
                dayDisplay.setText(days[nd]);
                s1.setText(arr[nd][0]);
                s2.setText(arr[nd][1]);
                s3.setText(arr[nd][2]);
                s4.setText(arr[nd][3]);
                s5.setText(arr[nd][4]);
                s6.setText(arr[nd][5]);
                s7.setText(arr[nd][6]);
                s8.setText(arr[nd][7]);
            }
        });

        this.mHandler = new Handler();
        m_Runnable.run();
    }

    private final Runnable m_Runnable = new Runnable()
    {
        public void run()

        {
            Calendar calendar = Calendar.getInstance();
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int minute = calendar.get(Calendar.MINUTE);
            int t = hour*60 + minute;
            if(t>=480){
                r1.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=530){
                r2.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=580){
                r3.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=590){
                r4.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=640){
                r5.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=690){
                r6.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=740){
                r7.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=790){
                r8.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=840){
                r9.setBackgroundColor(resource.getColor(R.color.hblue));
            }
            if(t>=890){
                r10.setBackgroundColor(resource.getColor(R.color.hblue));
            }

            MainActivity2.this.mHandler.postDelayed(m_Runnable,20000);
        }

    };
}