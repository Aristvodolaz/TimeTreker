package com.example.timetrekerforandroid.view;

import com.example.timetrekerforandroid.db.UserTimeData;

import java.util.List;

public interface GetInfoTimeView {

    void getInfoTime(List<UserTimeData> data);
    void showMessage(String msg);
}
