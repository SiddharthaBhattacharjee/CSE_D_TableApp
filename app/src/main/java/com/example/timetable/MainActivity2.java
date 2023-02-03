package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.drawable.DrawableCompat;

import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
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
            {"SEPM - BMS 502","DAA - BMS 502","Maths - BMS 502","OS - BMS 502","VAC - BMS 502","VAC - BMS 502","APP - BMS 502","CC - BMS 502"},
            {"APP (Lab - 7)","APP (Lab - 7)","SEPM (Lab - 8)","SEPM (Lab - 8)","SEPM - BMS 502","OS - BMS 502","Maths - BMS 502","DAA - BMS 502"},
            {"CC - AD 301","APP - AD 301","DAA - AD 301","EVS - AD 301","CCTS - AD 202","CCTS - AD 202","OS - AD 202","SEPM - AD 202"},
            {"Maths - AD 606","OS - AD 606","APP - AD 606","DAA - AD 606","OS (Lab - 4,5)","OS (Lab - 4,5)","DAA (Lab - 6)","DAA (Lab - 6)"},
            {"CC(Lab - IOT/MP)","CC(Lab - IOT/MP)","CC - BMS 502","SEPM - BMS 502","Maths - BMS 502","APP - BMS 502","SE - BMS 502","SE - BMS 502"},
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

        SharedPreferences sh = getSharedPreferences("data",MODE_PRIVATE);

        String st1 = sh.getString("0", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta1 = st1.split(";");
        String st2 = sh.getString("1", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta2 = st2.split(";");
        String st3 = sh.getString("2", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta3 = st3.split(";");
        String st4 = sh.getString("3", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta4 = st4.split(";");
        String st5 = sh.getString("4", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta5 = st5.split(";");
        String st6 = sh.getString("5", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta6 = st6.split(";");
        String st7 = sh.getString("6", "NULL;NULL;NULL;NULL;NULL;NULL;NULL;NULL");
        String[] sta7 = st7.split(";");
        arr[0] = sta1;
        arr[1] = sta2;
        arr[2] = sta3;
        arr[3] = sta4;
        arr[4] = sta5;
        arr[5] = sta6;
        arr[6] = sta7;

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
        //test here
//        t=560;
        resource = this.getResources();
        if(t>=480){
            Drawable TBDrawable = r1. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r1. setBackground(TBDrawable);
        }
        if(t>=530){
            Drawable TBDrawable = r2. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r2. setBackground(TBDrawable);

            Drawable TBDrawable2 = r1. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r1. setBackground(TBDrawable2);
        }
        if(t>=580){
            Drawable TBDrawable = r3. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r3. setBackground(TBDrawable);

            Drawable TBDrawable2 = r2. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r2. setBackground(TBDrawable2);
        }
        if(t>=590){
            Drawable TBDrawable = r4. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r4. setBackground(TBDrawable);

            Drawable TBDrawable2 = r3. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r3. setBackground(TBDrawable2);
        }
        if(t>=640){
            Drawable TBDrawable = r5. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r5. setBackground(TBDrawable);

            Drawable TBDrawable2 = r4. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r4. setBackground(TBDrawable2);
        }
        if(t>=690){
            Drawable TBDrawable = r6. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r6. setBackground(TBDrawable);

            Drawable TBDrawable2 = r5. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r5. setBackground(TBDrawable2);
        }
        if(t>=740){
            Drawable TBDrawable = r7. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r7. setBackground(TBDrawable);

            Drawable TBDrawable2 = r6. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r6. setBackground(TBDrawable2);
        }
        if(t>=790){
            Drawable TBDrawable = r8. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r8. setBackground(TBDrawable);

            Drawable TBDrawable2 = r7. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r7. setBackground(TBDrawable2);
        }
        if(t>=840){
            Drawable TBDrawable = r9. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r9. setBackground(TBDrawable);

            Drawable TBDrawable2 = r8. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r8. setBackground(TBDrawable2);
        }
        if(t>=890){
            Drawable TBDrawable = r10. getBackground();
            TBDrawable = DrawableCompat. wrap(TBDrawable);
            DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
            r10. setBackground(TBDrawable);

            Drawable TBDrawable2 = r9. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r9. setBackground(TBDrawable2);
        }

        if(t>=940){
            Drawable TBDrawable2 = r10. getBackground();
            TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
            DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
            r10. setBackground(TBDrawable2);
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
            //test here
//            t=560;
            if(t>=480){
                Drawable TBDrawable = r1. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r1. setBackground(TBDrawable);
            }
            if(t>=530){
                Drawable TBDrawable = r2. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r2. setBackground(TBDrawable);

                Drawable TBDrawable2 = r1. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r1. setBackground(TBDrawable2);
            }
            if(t>=580){
                Drawable TBDrawable = r3. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r3. setBackground(TBDrawable);

                Drawable TBDrawable2 = r2. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r2. setBackground(TBDrawable2);
            }
            if(t>=590){
                Drawable TBDrawable = r4. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r4. setBackground(TBDrawable);

                Drawable TBDrawable2 = r3. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r3. setBackground(TBDrawable2);
            }
            if(t>=640){
                Drawable TBDrawable = r5. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r5. setBackground(TBDrawable);

                Drawable TBDrawable2 = r4. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r4. setBackground(TBDrawable2);
            }
            if(t>=690){
                Drawable TBDrawable = r6. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r6. setBackground(TBDrawable);

                Drawable TBDrawable2 = r5. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r5. setBackground(TBDrawable2);
            }
            if(t>=740){
                Drawable TBDrawable = r7. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r7. setBackground(TBDrawable);

                Drawable TBDrawable2 = r6. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r6. setBackground(TBDrawable2);
            }
            if(t>=790){
                Drawable TBDrawable = r8. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r8. setBackground(TBDrawable);

                Drawable TBDrawable2 = r7. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r7. setBackground(TBDrawable2);
            }
            if(t>=840){
                Drawable TBDrawable = r9. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r9. setBackground(TBDrawable);

                Drawable TBDrawable2 = r8. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r8. setBackground(TBDrawable2);
            }
            if(t>=890){
                Drawable TBDrawable = r10. getBackground();
                TBDrawable = DrawableCompat. wrap(TBDrawable);
                DrawableCompat. setTint(TBDrawable, getResources().getColor(R.color.hPurple));
                r10. setBackground(TBDrawable);

                Drawable TBDrawable2 = r9. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r9. setBackground(TBDrawable2);
            }

            if(t>=940){
                Drawable TBDrawable2 = r10. getBackground();
                TBDrawable2 = DrawableCompat. wrap(TBDrawable2);
                DrawableCompat. setTint(TBDrawable2, getResources().getColor(R.color.white));
                r10. setBackground(TBDrawable2);
            }

            MainActivity2.this.mHandler.postDelayed(m_Runnable,20000);
        }

    };
}