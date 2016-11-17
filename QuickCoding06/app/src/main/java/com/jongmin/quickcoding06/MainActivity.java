package com.jongmin.quickcoding06;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager sm;

    private Sensor sensor_gravity;
    private Sensor sensor_accelerometer;
    private Sensor sensor_linear_acceleration;
    private Sensor sensor_gyroscope;

    TextView x_gravity;
    TextView y_gravity;
    TextView z_gravity;
    TextView x_accelerometer;
    TextView y_accelerometer;
    TextView z_accelerometer;
    TextView x_linear_acceleration;
    TextView y_linear_acceleration;
    TextView z_linear_acceleration;
    TextView x_gyroscope;
    TextView y_gyroscope;
    TextView z_gyroscope;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        sm = (SensorManager)getSystemService(SENSOR_SERVICE);

        sensor_gravity = sm.getDefaultSensor(Sensor.TYPE_GRAVITY);
        sensor_accelerometer = sm.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensor_linear_acceleration = sm.getDefaultSensor(Sensor.TYPE_LINEAR_ACCELERATION);
        sensor_gyroscope = sm.getDefaultSensor(Sensor.TYPE_GYROSCOPE);

        x_gravity = (TextView)findViewById(R.id.textView6);
        y_gravity = (TextView)findViewById(R.id.textView7);
        z_gravity = (TextView)findViewById(R.id.textView8);
        x_accelerometer = (TextView)findViewById(R.id.textView9);
        y_accelerometer = (TextView)findViewById(R.id.textView10);
        z_accelerometer = (TextView)findViewById(R.id.textView11);
        x_linear_acceleration = (TextView)findViewById(R.id.textView12);
        y_linear_acceleration = (TextView)findViewById(R.id.textView13);
        z_linear_acceleration = (TextView)findViewById(R.id.textView14);
        x_gyroscope = (TextView)findViewById(R.id.textView15);
        y_gyroscope = (TextView)findViewById(R.id.textView16);
        z_gyroscope = (TextView)findViewById(R.id.textView17);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // 센서 리스너에 등록
        sm.registerListener(this, sensor_gravity, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_accelerometer, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_linear_acceleration, SensorManager.SENSOR_DELAY_NORMAL);
        sm.registerListener(this, sensor_gyroscope, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // 센서 리스너 해제
        sm.unregisterListener(this);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
        // 아무 동작 안함
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        switch(event.sensor.getType()) {
            case Sensor.TYPE_GRAVITY:
                x_gravity.setText("X: " + event.values[0]);
                y_gravity.setText("Y: " + event.values[1]);
                z_gravity.setText("Z: " + event.values[2]);
                break;

            case Sensor.TYPE_ACCELEROMETER:
                x_accelerometer.setText("X: " + event.values[0]);
                y_accelerometer.setText("Y: " + event.values[1]);
                z_accelerometer.setText("Z: " + event.values[2]);
                break;

            case Sensor.TYPE_LINEAR_ACCELERATION:
                x_linear_acceleration.setText("X: " + event.values[0]);
                y_linear_acceleration.setText("Y: " + event.values[1]);
                z_linear_acceleration.setText("Z: " + event.values[2]);
                break;

            case Sensor.TYPE_GYROSCOPE:
                x_gyroscope.setText("X: " + event.values[0]);
                y_gyroscope.setText("Y: " + event.values[1]);
                z_gyroscope.setText("Z: " + event.values[2]);
                break;
        }
    }
}
