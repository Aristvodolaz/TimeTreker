package com.example.timetrekerforandroid.presenter;
import android.util.Log;

import androidx.annotation.NonNull;

import com.example.timetrekerforandroid.db.UserData;
import com.example.timetrekerforandroid.db.Users;
import com.example.timetrekerforandroid.util.ReadRxDataUtil;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.util.WriteRxDataUtil;
import com.example.timetrekerforandroid.view.GetTypeUserView;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;
import com.google.firebase.firestore.QuerySnapshot;
import com.google.firebase.firestore.auth.User;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.CompletableObserver;
import io.reactivex.rxjava3.core.Observer;
import io.reactivex.rxjava3.disposables.Disposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class GetTypeUserPresenter {
    private GetTypeUserView view;

    public GetTypeUserPresenter(GetTypeUserView view) {
        this.view = view;
    }

    public void getCreate(){
        String databaseURL = "https://timer-d0fbd-default-rtdb.europe-west1.firebasedatabase.app";
        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference databaseReference = database.getReference();
        UserData userData = new UserData(
                "Арина",
                "Прокопенко",
                "ИСТ-401",
                "1",
                "Инженерно-экономический институт",
                "Информационных технологий",
                "22.03.2002",
                "kap.moral@mail.ru"
        );
        String login = "kap.moral@mail.ru";
        String modifiedLogin = login.replace(".", "_"); // Заменяем "." на "_"

        DatabaseReference usersRef = databaseReference.child("Users");
        DatabaseReference userLoginRef = usersRef.child(modifiedLogin);
        userLoginRef.setValue(userData);


    }

    public void getTypeUser(String login) {

        String databaseURL = "https://timer-d0fbd-default-rtdb.europe-west1.firebasedatabase.app";
        FirebaseDatabase database = FirebaseDatabase.getInstance(databaseURL);
        DatabaseReference databaseReference = database.getReference();
        String modifiedLogin = login.replace(".", "_"); //

        DatabaseReference userLoginRef = databaseReference.child("Users").child(modifiedLogin);
        userLoginRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()) {
                    UserData userData = snapshot.getValue(UserData.class);
                    if (userData != null) {
                        SPHelper.setLogin(userData.getLogin());
                        SPHelper.setCafedra(userData.getCafedra());
                        SPHelper.setGroup(userData.getGroup());
                        SPHelper.setName(userData.getName());
                        SPHelper.setSurname(userData.getSurname());
                        SPHelper.setInstitute(userData.getInstitute());
                        view.typeUser(userData.getType());
                    }
                } else {
                    view.typeUser("Пользователь не найден");
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                view.showMessage(databaseError.getMessage());
            }
        });
    }
}

