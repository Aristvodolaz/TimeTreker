package com.example.timetrekerforandroid.presenter;

import androidx.annotation.NonNull;

import com.example.timetrekerforandroid.db.UserData;
import com.example.timetrekerforandroid.db.UserTimeData;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.GetInfoTimeView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class GetInfoTimePresenter {
    private GetInfoTimeView view;

    public GetInfoTimePresenter(GetInfoTimeView view) {
        this.view = view;
    }

    public void getFullTimeInfo(String login){
        String databaseURL = "https://timer-d0fbd-default-rtdb.europe-west1.firebasedatabase.app";
        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference databaseReference = database.getReference();

        List<UserTimeData> forPerson = new ArrayList<>();

        DatabaseReference userLoginRef = databaseReference.child("Trakking");
        userLoginRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                forPerson.clear();

                for (DataSnapshot childSnapshot : dataSnapshot.getChildren()) {
                    UserTimeData value = childSnapshot.getValue(UserTimeData.class);
                    if (value != null && value.getLogin().equals(login)) {
                        forPerson.add(value);
                    }
                }
                view.getInfoTime(forPerson);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                view.showMessage(databaseError.getMessage());
            }
        });
    }
}
