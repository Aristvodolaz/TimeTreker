package com.example.timetrekerforandroid.fragment.user;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.adapter.InfoTimeAdapter;
import com.example.timetrekerforandroid.db.UserTimeData;
import com.example.timetrekerforandroid.fragment.BaseFragment;
import com.example.timetrekerforandroid.presenter.GetInfoTimePresenter;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.GetInfoTimeView;

import java.util.List;

import butterknife.BindView;

public class InfoFragment extends BaseFragment implements GetInfoTimeView {
    @BindView(R.id.rv_info)
    RecyclerView rvInfo;

    public GetInfoTimePresenter presenter;
    public static final String LOGIN = "login_name";
    public static InfoFragment newInstance(String login) {
        Bundle args = new Bundle();
        args.putString(LOGIN, login);
        InfoFragment fragment = new InfoFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initViews() {
        super.initViews();

        presenter = new GetInfoTimePresenter(this);

        presenter.getFullTimeInfo(SPHelper.getLogin());

    }

    @Override
    protected int layoutId() {
        return R.layout.info_fragment;
    }

    @Override
    public void getInfoTime(List<UserTimeData> data) {
        if(!data.isEmpty()){
            InfoTimeAdapter adapter = new InfoTimeAdapter(data, getContext());
            rvInfo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
            rvInfo.setAdapter(adapter);
        }
    }

    @Override
    public void showMessage(String msg) {

    }
}
