package com.example.calenderapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class MemoActivity extends AppCompatActivity {
    int year, month, day;
    Filemanager fm = new Filemanager(this);
    EditText editMemo = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memo);
        Intent intent = getIntent();
        editMemo = (EditText)findViewById(R.id.memo);
        Button homebnt = (Button)findViewById(R.id.homebnt);

        homebnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        int year = intent.getExtras().getInt("year");
        int month = intent.getExtras().getInt("month");
        int day = intent.getExtras().getInt("day");

        String data = fm.load();
        if(year==0){
            editMemo.setText(data + "\n");
        }
        else {
            editMemo.setText(data + "\n" + year + " 년" + month + " 월" + day + " 일 :");
        }
    }

    public void load(View view){
        String data = fm.load();
        editMemo.setText(data);
        Toast.makeText(this, "불러오기 완료", Toast.LENGTH_LONG).show();
    }

    public void save(View view){
        String data = editMemo.getText().toString();
        fm.save(data);
        editMemo.setText("");
        Toast.makeText(this, "저장 완료", Toast.LENGTH_LONG).show();
    }
    public void del(View view){
        fm.delete();
        editMemo.setText("");
        Toast.makeText(this, "삭제 완료", Toast.LENGTH_LONG).show();
    }
}

