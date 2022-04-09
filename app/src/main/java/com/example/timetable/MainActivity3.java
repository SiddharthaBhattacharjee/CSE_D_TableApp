package com.example.timetable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {
    String[][] food = {
            {"BreadJam, Tea, Coffee, Idiyappam, Chappati, Black Channa Curry, Coconut Milk",
            "Keersi Sambar, Milagu rasam, Cabbage poriyal, Steam rice, Mixveg Curry, Chappati, Butter Milk, Appalam, Pickle",
            "Veg Puff, Tea, Coffee",
            "Veg Pulao, Mix Raitah, Chappati, Green peas Masala, Pickle, Banana, Milk"},
            {"BreadJam, Tea, Coffee, Idli, Sambar, Coconut Chutney",
            "Vatha Kozhambu, Pineapple rasam, Keerai Kottu, Steam Rice, Masala Dal, Chappati, Buttermilk, Apallam, Pickle",
            "French Heart, Tea, Coffee",
            "Chappati, Steam Rice, Sambhar, Rasam, Tidly Masala, Appalam, Pickle, Milk"},
            {"BreadJam, Tea, Coffee, Poori, Potato Masala, Chappathi, Veg Khorma",
            "Kadhamba Sambar, Mint rassam, Mix veg Poriyal, Stream rice, Rajma dal, Chappati,, ButterMilk, Appalam, pickle",
            "Samosa, Tea, Coffee",
            "Paratha, Chicken Curry, Paneer Butter Masala, Steam Rice, Rasam, Appallam, Pickle, Milk"},
            {"BreadJam, Tea, Coffee, Kal Dosa, Sambar, Tomato Chutney",
            "More Kozhambu, Paruppu Rasam, Kathiri, Urulia Moccha Masala, Stream Rice, Chappati, Butter Milk, Appalam, Pickle, Greem pees masala",
            "Choco Vanilla Cake, Tea, Coffee",
            "Tomato & chick peas Pulao, Raitha, Chappathi, Dal Fry, Pickle, Milk, Banana"
            },
            {"BreadJam, Tea, Coffee, Rava Khichadi, Sambhar, Coconut Chutney",
            "Variety Rice, Steam Rice, Tomato Rasam, Chappathi, Potato Roast, ButterMilk, Appalam, Pickle, Yellow Dal Dry",
            "Fruit Muffin, Tea, Coffee",
                    "Idly, Sambar, Chutney, Chappati, Kadai Veg, Banana, Milk"},
            {"BreadJam, Tea, Coffee, Ghee Pongl, Medhu Bonda, Sambar, Coconut Chutney",
                    "Kathiri Karakozhambu, Parupu Rasam, Kadambu Kootu, Stream Rice, Chappati, ButterMilk, Appalam, Picklr, Veg Kurma",
                    "Cream Bun, Tea, Coffee",
                    "Chappathi, Gobi Peas Gravy, Stream Rice, Sambhar, Rasam, Vazhakkai Masala, Appalam, Pickle, Milk"
            },
            {"BreadJam, Tea, Coffee, Chole Poori Channa Masala",
            "Chicken Biriyani, Veg Biriyani, Raitha, Tomato Rasam, Stream Rice, Butter Milk, Apalam, Pickle",
            "Masla Vada, Tea, Coffee",
            "Kal Dosa, Sambhar, Chutney, Chappathi, Rajma Dal, Banana,, Milk"}
    };
    String[] days = {"MONDAY","TUESDAY","WEDNESDAY","THURSDAY","FRIDAY","SATURDAY","SUNDAY"};
    TextView bf,lu,sn,di,dayDisplay2;
    ImageButton fwbtn,bwbtn;
    int nd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        bf = findViewById(R.id.bfmeal);
        lu = findViewById(R.id.lmeal);
        sn = findViewById(R.id.smeal);
        di = findViewById(R.id.dmeal);
        fwbtn = findViewById(R.id.forwbtn2);
        bwbtn = findViewById(R.id.backbtn2);
        dayDisplay2 = findViewById(R.id.dayview2);

        Calendar calendar = Calendar.getInstance();
        int day = calendar.get(Calendar.DAY_OF_WEEK);

        switch (day) {
            case Calendar.SUNDAY:
                nd=6;
                dayDisplay2.setText("SUNDAY");
                break;
            case Calendar.MONDAY:
                nd=0;
                dayDisplay2.setText("MONDAY");
                break;
            case Calendar.TUESDAY:
                nd=1;
                dayDisplay2.setText("TUESDAY");
                break;
            case Calendar.WEDNESDAY:
                nd=2;
                dayDisplay2.setText("WEDNESDAY");
                break;
            case Calendar.THURSDAY:
                nd=3;
                dayDisplay2.setText("THURSDAY");
                break;
            case Calendar.FRIDAY:
                nd=4;
                dayDisplay2.setText("FRIDAY");
                break;
            case Calendar.SATURDAY:
                nd=5;
                dayDisplay2.setText("SATURDAY");
                break;
            default:
                nd=5;
                break;
        }
        bf.setText(food[nd][0]);
        lu.setText(food[nd][1]);
        sn.setText(food[nd][2]);
        di.setText(food[nd][3]);

        fwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nd==6){
                    nd=0;
                }
                else{
                    nd+=1;
                }
                dayDisplay2.setText(days[nd]);
                bf.setText(food[nd][0]);
                lu.setText(food[nd][1]);
                sn.setText(food[nd][2]);
                di.setText(food[nd][3]);

            }
        });

        bwbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nd==0){
                    nd=6;
                }
                else{
                    nd -= 1;
                }
                dayDisplay2.setText(days[nd]);
                bf.setText(food[nd][0]);
                lu.setText(food[nd][1]);
                sn.setText(food[nd][2]);
                di.setText(food[nd][3]);
            }
        });
    }
}