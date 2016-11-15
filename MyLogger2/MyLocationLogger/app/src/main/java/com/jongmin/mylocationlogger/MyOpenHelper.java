package com.jongmin.mylocationlogger;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by JongMin on 2016-11-15.
 */
public class MyOpenHelper extends SQLiteOpenHelper {

    Context context;
    public MyOpenHelper(Context context) {
        super(context, "data.sqlite", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE member (latitude DOUBLE, longitude DOUBLE, life TEXT);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("CREATE TABLE member (latitude DOUBLE, longitude DOUBLE, life TEXT);");
    }
}
