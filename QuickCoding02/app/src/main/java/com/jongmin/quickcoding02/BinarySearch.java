package com.jongmin.quickcoding02;

/**
 * Created by JongMin on 2016-10-04.
 */
public class BinarySearch extends MainActivity {

    public int bs (int min, int max)
    {
        int num[];
        num = new int[max-min+1];
        int temp = min;

        for (int i=0; i<num.length; i++) {
            num[i] = temp;
            ++temp;
        }

        return num[num.length/2];
    }

}
