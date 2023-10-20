package com.example.timetrekerforandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.LoginFragment;
import com.example.timetrekerforandroid.presenter.GetTypeUserPresenter;
import com.example.timetrekerforandroid.view.GetTypeUserView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreSettings;

public class LoginActivity extends BaseActivity implements GetTypeUserView {
    FirebaseAuth auth;
    FirebaseUser user;
    private GetTypeUserPresenter presenter;
    boolean type_user;
    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        auth = FirebaseAuth.getInstance();
        user = auth.getCurrentUser();
        presenter = new GetTypeUserPresenter(this);

        if (user != null) {
//            presenter.getCreate();
            presenter.getTypeUser(user.getEmail());
        } else replaceFragment(LoginFragment.newInstance(), true);

    }

    @Override
    protected int layoutResId() {
        return R.layout.login_activity;
    }

    @Override
    protected int titleResId() {
        return 0;
    }

    @Override
    public void typeUser(String type) {
        type_user = type.equals("0");
        startActivity(type_user?new Intent(this,HeadActivity.class): new Intent(this, UserActivity.class));
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
}
