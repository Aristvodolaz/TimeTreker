package com.example.timetrekerforandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.user.InfoFragment;
import com.example.timetrekerforandroid.fragment.user.UserStartFragment;
import com.example.timetrekerforandroid.util.SPHelper;

import butterknife.BindView;

public class UserActivity extends BaseActivity{
    @BindView(R.id.time_btn) LinearLayout timeBtn;
    @BindView(R.id.qrcode_btn) LinearLayout qrcodeBtn;
    @BindView(R.id.person_btn) LinearLayout personBtn;

    @Override
    protected void initViews(@Nullable Bundle saveInstanceState) {
        replaceFragment(UserStartFragment.newInstance(SPHelper.getLogin()), true);

        timeBtn.setOnClickListener(l->{
            replaceFragment(InfoFragment.newInstance(SPHelper.getLogin()),true);
        });
        qrcodeBtn.setOnClickListener(l->{
//            replaceFragment(ScanFragment.newInstance(), true);
            startActivity(new Intent(this,CameraActivity.class));
        });
        personBtn.setOnClickListener(l->{
            replaceFragment(UserStartFragment.newInstance(SPHelper.getLogin()),true);
        });
    }
    public void replaceFragment(Fragment fragment, boolean addToBackStack) {
        FragmentTransaction fragmentTransaction =
                getSupportFragmentManager()
                        .beginTransaction()
                        .replace(R.id.container, fragment, fragment.getClass().getSimpleName());
        if (addToBackStack) fragmentTransaction.addToBackStack(fragment.getClass().getName());
        fragmentTransaction.commit();
    }
    @Override
    protected int layoutResId() {
        return R.layout.user_activity;
    }

    @Override
    protected int titleResId() {
        return 0;
    }
}
