package com.example.calenderapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.Date;
import java.text.SimpleDateFormat;


public class MainActivity extends AppCompatActivity {
    CalendarView cal;
    TextView text1, text2;
    int selectYear,selectMonth,selectDay;

    long now = System.currentTimeMillis();
    Date date = new Date(now);
    SimpleDateFormat sdfNow = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
    String formatDate = sdfNow.format(date);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cal= (CalendarView)findViewById(R.id.calendarView);
        text1 = (TextView)findViewById(R.id.textView);
        text2 = (TextView)findViewById(R.id.textView4);
        Button btn = (Button) findViewById(R.id.btn);
        text2.setText(formatDate);
        cal.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView view, int year, int month, int dayOfMonth) {
                selectYear = year;
                selectMonth = month+1;
                selectDay = dayOfMonth;
                text1.setText(year + "년 " + (month + 1) + "월 " + dayOfMonth + "일");
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MemoActivity.class);
                intent.putExtra("year",selectYear);
                intent.putExtra("month",selectMonth);
                intent.putExtra("day",selectDay);
                startActivity(intent);
            }
        });
    }
}