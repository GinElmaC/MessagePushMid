package com.GinElmaC.test;

import java.util.Date;

public class Message {
    String date;
    String time;
    public void setDate(String date) {
        Date date1 = new Date();
        this.date = date;
        time = date1.toString();
    }
}
