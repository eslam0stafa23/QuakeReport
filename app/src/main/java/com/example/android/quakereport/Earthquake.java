package com.example.android.quakereport;

public class Earthquake {

    private Double mMag;

    private String mLocation;

    private long mDateInMilliseconds;

    private String mUrl;

    public Earthquake(Double mag, String location, long dateInMilliseconds, String url) {

        mMag = mag;
        mLocation = location;
        mDateInMilliseconds = dateInMilliseconds;
        mUrl = url;
    }

    public Double getmMag() {
        return mMag;
    }

    public String getmLocation() {
        return mLocation;
    }

    public long getmDateInMilliseconds() {
        return mDateInMilliseconds;
    }

    public String getmUrl() {
        return mUrl;
    }
}
