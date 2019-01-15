package com.example.android.quakereport;

public class Earthquake {

    private String mMag;

    private String mCity;

    private String mDate;

    public Earthquake(String mag, String city, String date) {

        mMag = mag;
        mCity = city;
        mDate = date;
    }

    public String getmMag() {
        return mMag;
    }

    public String getmCity() {
        return mCity;
    }

    public String getmDate() {
        return mDate;
    }
}
