package com.example.calenderapp;

import android.content.Context;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Filemanager{
    private static final String FILE = "MEMO.txt";
    Context con = null;

    public Filemanager(MemoActivity memoActivity) {
        con = memoActivity;
    }

    public void save(String data) {
        if (data == null || data.equals("")) {
            return;
        }

        FileOutputStream oStream = null;

        try {
            oStream = con.openFileOutput(FILE, Context.MODE_PRIVATE);
            oStream.write(data.getBytes());
            oStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public String load() {
        try {
            FileInputStream iStream = con.openFileInput(FILE);
            byte[] data = new byte[iStream.available()];
            while(iStream.read(data)!=-1){}
            return new String(data);
        } catch (Exception e) {}
        return "";
    }
    public void delete(){
        con.deleteFile(FILE);
    }
}
