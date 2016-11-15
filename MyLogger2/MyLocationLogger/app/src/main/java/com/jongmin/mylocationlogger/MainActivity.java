package com.jongmin.mylocationlogger;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Point;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.common.GooglePlayServicesUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.MapsInitializer;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

public class MainActivity extends FragmentActivity implements OnMapClickListener, CommonData {

    private GoogleMap mGoogleMap;
    int cnt = 0;

    Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message msg) {
            init();
            mHandler.sendEmptyMessageDelayed(0,1000*60*30); // 30분마다 GPS 기록
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Intent AddInt = new Intent(this, AddActivity.class);
        final Intent StatInt = new Intent(this, StatActivity.class);

        Button AddBtn = (Button) findViewById(R.id.button);
        Button StatBtn = (Button) findViewById(R.id.button2);

        AddBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(AddInt);
            }
        });

        StatBtn.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                startActivity(StatInt);
            }
        });

        // BitmapDescriptorFactory 생성하기 위한 소스
        MapsInitializer.initialize(getApplicationContext());

        mHandler.sendEmptyMessage(0);       // init 반복하기 위한 핸들러
    }

    /** Map 클릭시 터치 이벤트 */
    public void onMapClick(LatLng point) {

        // 현재 위도와 경도에서 화면 포인트를 알려준다
        Point screenPt = mGoogleMap.getProjection().toScreenLocation(point);

        // 현재 화면에 찍힌 포인트로 부터 위도와 경도를 알려준다.
        LatLng latLng = mGoogleMap.getProjection().fromScreenLocation(screenPt);

        Log.d("맵좌표", "좌표: 위도(" + String.valueOf(point.latitude) + "), 경도("
                + String.valueOf(point.longitude) + ")");
        Log.d("화면좌표", "화면좌표: X(" + String.valueOf(screenPt.x) + "), Y("
                + String.valueOf(screenPt.y) + ")");
    }

    /**
     * 초기화
     * @author
     */
    public void init() {
        GooglePlayServicesUtil.isGooglePlayServicesAvailable(this);

        mGoogleMap = ((SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map)).getMap();

        GpsInfo gps = new GpsInfo(this);

        // GPS 사용유무 가져오기
        if (gps.isGetLocation()) {
            m_lat_Array.add(0, gps.getLatitude());
            m_lon_Array.add(0, gps.getLongitude());

            // Creating a LatLng object for the current location
            m_loc_Array.add(0, new LatLng(m_lat_Array.get(0), m_lon_Array.get(0)));

            // Showing the current location in Google Map
            mGoogleMap.moveCamera(CameraUpdateFactory.newLatLng(m_loc_Array.get(0)));

            // Map 을 zoom 합니다.
            mGoogleMap.animateCamera(CameraUpdateFactory.zoomTo(13));

            ++cnt;
            // 마커 설정.
            MarkerOptions optFirst = new MarkerOptions();
            optFirst.position(m_loc_Array.get(0));// 위도 • 경도
            optFirst.title("Position " + cnt);// 제목 미리보기
            optFirst.snippet("Snippet");
            optFirst.icon(BitmapDescriptorFactory.fromResource(R.mipmap.ic_launcher));
            mGoogleMap.addMarker(optFirst).showInfoWindow();

            // 경로 직선 설정
            if (cnt>=2)
                mGoogleMap.addPolyline(new PolylineOptions().add(m_loc_Array.get(0), m_loc_Array.get(1)).width(5).color(Color.RED));

            // 24시간이 지나면 초기화
            if (cnt>48)
            {
                m_lat_Array.clear();        // 위도 기록 초기화
                m_lon_Array.clear();        // 경도 기록 초기화
                m_loc_Array.clear();        // GPS위치 정보 초기화 (위도 • 경도)

                cnt = 0;
            }
        }
    }
}