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

    public void SQLexec(String name, String Lat, String Lon, SQLiteDatabase db) {
        db.execSQL("insert into member(latitude, longitude, life) values ("
                + Lat + ", "
                + Lon + ", "
                + "'"+ name +"');"
        );
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        GpsInfo gps = new GpsInfo(this);

        final TextView LatTxt = (TextView) findViewById(R.id.lattxt);
        final TextView LonTxt = (TextView) findViewById(R.id.lontxt);

        LatTxt.setText(Double.toString(gps.getLatitude()));
        final String Latt = Double.toString(gps.getLatitude());
        LonTxt.setText(Double.toString(gps.getLongitude()));
        final String Lonn = Double.toString(gps.getLongitude());

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
                SQLexec("식사", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        ClaBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("수업", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        CarBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("대중교통", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        FriBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("친목", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        StuBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("공부", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        GamBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("게임", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });

        ExeBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                db = helper.getWritableDatabase();
                SQLexec("운동", Latt, Lonn, db);
                AddActivity.this.finish();
            }
        });
    }
}
