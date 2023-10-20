package com.example.timetrekerforandroid.view;

import com.example.timetrekerforandroid.db.TimeData;

import java.util.List;

public interface GetDataView {
    void showMessage(String msg);
    void getData(List<TimeData> data);
}
