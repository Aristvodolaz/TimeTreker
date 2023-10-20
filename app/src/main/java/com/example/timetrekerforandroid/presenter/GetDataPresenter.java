package com.example.timetrekerforandroid.presenter;

import com.example.timetrekerforandroid.db.TimeData;
import com.example.timetrekerforandroid.util.ReadRxDataUtil;
import com.example.timetrekerforandroid.view.GetDataView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;

import java.util.ArrayList;
import java.util.List;
public class GetDataPresenter {
    private GetDataView view;

    public GetDataPresenter(GetDataView view) {
        this.view = view;
    }

    public void getFullTime(String login){
        FirebaseFirestore firestore = FirebaseFirestore.getInstance();
        CollectionReference reference = firestore.collection("TimeData");
        ReadRxDataUtil.observeValueEvent(reference)
                .subscribe(
                        queryDocumentSnapshots -> {
                            List<TimeData> data = new ArrayList<>();

                            for (QueryDocumentSnapshot documentSnapshot : queryDocumentSnapshots) {
                                TimeData timeData = documentSnapshot.toObject(TimeData.class);
                                if (timeData.getLogin().equals(login)) {
                                    data.add(timeData);
                                }
                            }
                            view.getData(data);
                        },
                        throwable -> view.showMessage(throwable.getMessage())
                );
    }
}
