package com.example.timetrekerforandroid.fragment.user;

import android.os.Bundle;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.BaseFragment;

public class UserStartFragment extends BaseFragment {
    public static final String LOGIN ="login";
    public static UserStartFragment newInstance(String login) {
        Bundle args = new Bundle();
        args.putString(LOGIN, login);
        UserStartFragment fragment = new UserStartFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int layoutId() {
        return R.layout.user_fragment;
    }
}
