package com.jongmin.quickcoding07;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    int count = 0;
    int dir_UP = 0;
    int dir_DOWN = 0;
    double acceleration = 0;
    double gravity = 9.8;
    float x = 0f;
    float y = 0f;
    float z = 0f;

    TextView tv_count;

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv_count = (TextView)findViewById(R.id.textView2);

        mSensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 아무 동작 안함
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            x = event.values[0];
            y = event.values[1];
            z = event.values[2];
            acceleration = Math.sqrt(x*x+y*y+z*z);
        }

        if (acceleration - gravity > 5) {
            dir_UP = 1;
        }

        if (dir_UP == 1 && gravity - acceleration > 5) {
            dir_DOWN = 1;
        }

        if (dir_DOWN == 1) {
            count++;
            tv_count.setText("" + count);

            dir_UP = 0;
            dir_DOWN = 0;
        }
    }
}
