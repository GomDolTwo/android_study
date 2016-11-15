package com.jongmin.mylocationlogger;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by JongMin on 2016-11-13.
 */
public class AddActivity extends AppCompatActivity implements CommonData {
    MyOpenHelper helper = new MyOpenHelper(this);
    SQLiteDatabase db;

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
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'식사');"
                );

                AddActivity.this.finish();
            }
        });

        ClaBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'수업');"
                );

                AddActivity.this.finish();
            }
        });

        CarBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 대중교통
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'대중교통');"
                );

                AddActivity.this.finish();
            }
        });

        FriBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 친목
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'친목');"
                );

                AddActivity.this.finish();
            }
        });

        StuBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 공부
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'공부');"
                );

                AddActivity.this.finish();
            }
        });

        GamBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 게임
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'게임');"
                );

                AddActivity.this.finish();
            }
        });

        ExeBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                // 운동
                db = helper.getWritableDatabase();
                db.execSQL("insert into member(latitude, longitude, life) values ("
                        + m_lat_Array.get(0) + ", "
                        + m_lon_Array.get(0) + ", "
                        + "'운동');"
                );

                AddActivity.this.finish();
            }
        });
    }
}
