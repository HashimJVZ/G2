package com.example.g2;

public class Schedule {

    private int start_hr;
    private int start_min;
    private int end_hr;
    private int end_min;
    private int day;
    private float starttime;
    private float endtime;

    public int getStart_hr() {
        return start_hr;
    }

    public void setStart_hr(int start_hr) {
        this.start_hr = start_hr;
    }

    public int getStart_min() {
        return start_min;
    }

    public void setStart_min(int start_min) {
        this.start_min = start_min;
    }

    public int getEnd_hr() {
        return end_hr;
    }

    public void setEnd_hr(int end_hr) {
        this.end_hr = end_hr;
    }

    public int getEnd_min() {
        return end_min;
    }

    public void setEnd_min(int end_min) {
        this.end_min = end_min;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public float getStarttime() {
        return starttime;
    }

    public void setStarttime(float starttime) {
        this.starttime = starttime;
    }

    public float getEndtime() {
        return endtime;
    }

    public void setEndtime(float endtime) {
        this.endtime = endtime;
    }
}
