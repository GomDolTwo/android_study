package com.jongmin.mylocationlogger;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JongMin on 2016-11-13.
 */
public class AddActivity extends AppCompatActivity implements CommonData {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        final TextView LatTxt = (TextView) findViewById(R.id.lattxt);
        final TextView LonTxt = (TextView) findViewById(R.id.lontxt);

        LatTxt.setText(Double.toString(m_lat_Array.get(0)));
        LonTxt.setText(Double.toString(m_lon_Array.get(0)));

        Button EatBtn = (Button) findViewById(R.id.button3);    // 식사
        Button ClaBtn = (Button) findViewById(R.id.button4);    // 수업
        Button CarBtn = (Button) findViewById(R.id.button5);    // 대중교통
        Button FriBtn = (Button) findViewById(R.id.button6);    // 친목
        Button StuBtn = (Button) findViewById(R.id.button7);    // 공부
        Button GamBtn = (Button) findViewById(R.id.button8);    // 게임
        Button ExeBtn = (Button) findViewById(R.id.button9);    // 운동

        EatBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        ClaBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        CarBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        FriBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        StuBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        GamBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        ExeBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });
    }
}
