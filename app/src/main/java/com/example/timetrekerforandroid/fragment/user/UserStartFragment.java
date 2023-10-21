package com.example.timetrekerforandroid.fragment.user;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.SurfaceView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.BaseFragment;

import butterknife.BindView;

public class UserStartFragment extends BaseFragment {
    public static final String LOGIN ="login";

    @BindView(R.id.exit)
    SurfaceView exitBtn;

    public static UserStartFragment newInstance(String login) {
        Bundle args = new Bundle();
        args.putString(LOGIN, login);
        UserStartFragment fragment = new UserStartFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        super.initViews();
        exitBtn.setOnClickListener(l->{
            AlertDialog.Builder mBuilder = new AlertDialog.Builder(getContext());
            mBuilder.setTitle("Подтверждение");
            mBuilder.setMessage("Вы уверены что хотите выйти?");
            mBuilder.setPositiveButton("Да", null);
            mBuilder.setNegativeButton("Нет", null);
            mBuilder.show();

            Button mPositiveButton = mBuilder.create().getButton(AlertDialog.BUTTON_POSITIVE);
            mPositiveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    System.exit(0);
                }
            });
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.user_fragment;
    }
}
