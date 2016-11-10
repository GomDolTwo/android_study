package com.jongmin.quickcoding02;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int num = 34;
    int count = 1;
    Random random = new Random();
    int ran = random.nextInt(100)+1;
    int min = 1;
    int max = 100;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final BinarySearch bins = new BinarySearch();

        Button SmallBtn = (Button) findViewById(R.id.smlbtn);
        Button BigBtn = (Button) findViewById(R.id.bigbtn);
        Button CorBtn = (Button) findViewById(R.id.corbtn);

        final TextView showResult = (TextView) findViewById(R.id.resultview);
        final TextView ansResult = (TextView) findViewById(R.id.answerview);

        ansResult.setText("Answer Number is " + num + "!!");
        showResult.setText("Your Number is " + ran + "!!");

        SmallBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                max = ran;
                ran = bins.bs(min, max);
                showResult.setText("Your Number is " + ran + "!!");
                ++count;
            }
        });

        BigBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                min = ran;
                ran = bins.bs(min, max);
                showResult.setText("Your Number is " + ran + "!!");
                ++count;
            }
        });

        CorBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v)
            {
                showResult.setText("Count : " + count);
            }
        });
    }
}
