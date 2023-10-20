package com.example.timetrekerforandroid.presenter;

import com.example.timetrekerforandroid.db.TimeData;
import com.example.timetrekerforandroid.db.UserTimeData;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.SendDataView;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class SendDataPresenter {
    private SendDataView view;

    public SendDataPresenter(SendDataView view) {
        this.view = view;
    }

    private String getTrueType(String text) {
        return text.replace(".", "_");
    }

    private String getTime(){
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm");
        return dateFormat.format(currentDate);
    }

    public void sendFullInfo(TimeData data){
        String databaseURL = "https://timer-d0fbd-default-rtdb.europe-west1.firebasedatabase.app";
        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference databaseReference = database.getReference("Trakking");

        String uniqueKey = getTrueType(SPHelper.getLogin())+SPHelper.getSurname()+getTrueType(getTime())+getTrueType(data.getData());

        if (data.type){
            databaseReference.child(uniqueKey).setValue(new UserTimeData(SPHelper.getName()+" "+SPHelper.getSurname(),
                SPHelper.getInstitute(),SPHelper.getCafedra(),SPHelper.getGroup(),data.time,"0",data.getData(),data.getCorpus(),SPHelper.getLogin()));
            SPHelper.setVhodTime(data.getTime());
            SPHelper.setLastUniqKey(uniqueKey);
        } else {
            Map<String, Object> updates = new HashMap<>();
            updates.put("vyhod", data.getTime());
            databaseReference.child(SPHelper.getLastUniqKey()).updateChildren(updates);
        }

    }
}
