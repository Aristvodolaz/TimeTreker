package com.example.timetrekerforandroid.activity;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.head.StartFragment;

public class HeadActivity extends BaseActivity{

    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        replaceFragment(StartFragment.newInstance(), true);
        //test commit for new devv
    }

    @Override
    protected int layoutResId() {
        return R.layout.head_activity;
    }

    @Override
    protected int titleResId() {
        return 0;
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
