package com.example.calenderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CalendarView;
import android.widget.TextView;

import com.example.calenderapp.R;

import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {
    CalendarView cal;
    TextView text1, text2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal= (CalendarView)findViewById(R.id.calendarView);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView4);
        CalenderViewListener listener = new CalenderViewListener();
        cal.setOnDateChangeListener(listener);
    }

    public void getDate(View view){
        long time = System.currentTimeMillis();
        Date date = new Date(time);
        SimpleDateFormat dataforming = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        String strDate = dataforming.format(date);
        text2.setText(strDate);
    }

    class CalenderViewListener implements CalendarView.OnDateChangeListener {
        public void onSelectedDayChange(CalendarView arg0, int year, int month, int day){
            text1.setText(year+"년 "+(month+1)+"월 "+day + "일");
        }

    }
}