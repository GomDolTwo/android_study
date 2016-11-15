package com.jongmin.mylocationlogger;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

/**
 * Created by JongMin on 2016-11-13.
 */
public class StatActivity extends AppCompatActivity {
    MyOpenHelper helper = new MyOpenHelper(this);
    SQLiteDatabase db;
    Cursor rs;
    String a = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stat);

        final TextView EatCnt = (TextView) findViewById(R.id.textView21); // 식사
        final TextView ClaCnt = (TextView) findViewById(R.id.textView22); // 수업
        final TextView CarCnt = (TextView) findViewById(R.id.textView23); // 대중교통
        final TextView FriCnt = (TextView) findViewById(R.id.textView24); // 친목
        final TextView StuCnt = (TextView) findViewById(R.id.textView25); // 공부
        final TextView GamCnt = (TextView) findViewById(R.id.textView26); // 게임
        final TextView ExeCnt = (TextView) findViewById(R.id.textView27); // 운동

        int eattemp = 0;
        int clatemp = 0;
        int cartemp = 0;
        int fritemp = 0;
        int stutemp = 0;
        int gamtemp = 0;
        int exetemp = 0;

        db = helper.getWritableDatabase();

        rs = db.rawQuery("select * from member;", null);

        while (rs.moveToNext()) {
            a = rs.getString(2);
            if (a.equals("식사"))
                ++eattemp;
            else if (a.equals("수업"))
                ++clatemp;
            else if (a.equals("대중교통"))
                ++cartemp;
            else if (a.equals("친목"))
                ++fritemp;
            else if (a.equals("공부"))
                ++stutemp;
            else if (a.equals("게임"))
                ++gamtemp;
            else if (a.equals("운동"))
                ++exetemp;
        }

        EatCnt.setText(Integer.toString(eattemp));
        ClaCnt.setText(Integer.toString(clatemp));
        CarCnt.setText(Integer.toString(cartemp));
        FriCnt.setText(Integer.toString(fritemp));
        StuCnt.setText(Integer.toString(stutemp));
        GamCnt.setText(Integer.toString(gamtemp));
        ExeCnt.setText(Integer.toString(exetemp));
    }
}
