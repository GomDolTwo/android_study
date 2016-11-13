package com.jongmin.mylocationlogger;

import com.google.android.gms.maps.model.LatLng;

import java.util.ArrayList;

/**
 * Created by JongMin on 2016-11-13.
 */
public interface CommonData {
    ArrayList<Double> m_lat_Array = new ArrayList<Double>();
    ArrayList<Double> m_lon_Array = new ArrayList<Double>();
    ArrayList<LatLng> m_loc_Array = new ArrayList<LatLng>();
}
