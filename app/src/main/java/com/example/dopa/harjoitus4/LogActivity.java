package com.example.dopa.harjoitus4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class LogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);

        DataClass data = new DataClass();
        TextView logView = findViewById(R.id.logView);

        data.readFromFile(this);
        logView.setText(getString(R.string.log_title) + "\n" + data.getData());
    }
}
