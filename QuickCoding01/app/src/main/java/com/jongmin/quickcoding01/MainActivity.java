package com.jongmin.quickcoding01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int num[] = {1, 3, 4, 7, 13, 24, 45};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void prtAvg(View v) {
        int result = 0;

        for (int i = 0; i < num.length; i++)
            result += num[i];
        result /= num.length;

        Toast.makeText(getApplicationContext(), "평균값은 " + result + " 입니다.", Toast.LENGTH_LONG).show();
    }

    public void prtMin(View v) {
        int result = num[0];

        for (int i=1; i<num.length; i++)
            if (result > num[i])
                result = num[i];

        Toast.makeText(getApplicationContext(), "최솟값은 " + result + " 입니다.", Toast.LENGTH_LONG).show();
    }
}
