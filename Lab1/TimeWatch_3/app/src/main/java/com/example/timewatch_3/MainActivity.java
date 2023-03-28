package com.example.timewatch_3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import java.util.Locale;
import android.view.View;
import java.util.Calendar;
import java.util.Date;
import java.text.SimpleDateFormat;

import android.widget.Button;
import android.os.Handler;


public class MainActivity extends AppCompatActivity {

    private Button showDatetimeButton;
    private TextView datetimeTextView;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showDatetimeButton = findViewById(R.id.showTimeBtn);

        datetimeTextView = findViewById(R.id.datetime_textview);
    }
}