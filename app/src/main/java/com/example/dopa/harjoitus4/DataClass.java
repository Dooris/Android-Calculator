package com.example.dopa.harjoitus4;

import android.content.Context;
import android.util.Log;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;

import static android.content.ContentValues.TAG;

/**
 * Class to handle data
 */

public class DataClass {
    private String data;

    public DataClass() {
        data = "";
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void writeToFile(Context ctx) {
        String filename = "myfile";
        FileOutputStream outputStream;
        try {
            outputStream = ctx.openFileOutput(filename, Context.MODE_PRIVATE);
            outputStream.write(data.getBytes());
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Kirjoitus ei onnistunut");
        }
    }

    public void readFromFile(Context ctx) {

        String filename = "myfile";
        FileInputStream fis;
        StringBuilder sb = new StringBuilder("moi");
        try {
            fis = ctx.openFileInput(filename);
            InputStreamReader isr = new InputStreamReader(fis);
            BufferedReader bufferedReader = new BufferedReader(isr);
            sb = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (Exception e) {
            e.printStackTrace();
            Log.d(TAG, "Luku ei onnistunut");
        }
        data = sb.toString();
    }
}
