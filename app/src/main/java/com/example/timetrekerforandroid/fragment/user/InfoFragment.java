package com.example.timetrekerforandroid.fragment.user;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.adapter.InfoTimeAdapter;
import com.example.timetrekerforandroid.db.UserTimeData;
import com.example.timetrekerforandroid.fragment.BaseFragment;
import com.example.timetrekerforandroid.presenter.GetInfoTimePresenter;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.GetInfoTimeView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import butterknife.BindView;

public class InfoFragment extends BaseFragment implements GetInfoTimeView {
    @BindView(R.id.rv_info)
    RecyclerView rvInfo;
    @BindView(R.id.today)
    TextView today;
    @BindView(R.id.time_vhod) TextView timeVhod;
    @BindView(R.id.time_vyhod) TextView timeVyhod;


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
        if (!data.isEmpty()) {
            today.setText("Сегодня " + getDate() + " " + getMonth());
            timeVhod.setText(data.get(data.size()-1).getData());
            timeVyhod.setText(data.get(data.size()-1).getData().equals("0")? "..." : data.get(data.size()-1).getData());
            InfoTimeAdapter adapter = new InfoTimeAdapter(data, getContext());
            rvInfo.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, true));
            rvInfo.setAdapter(adapter);
        } else
            Toast.makeText(getContext(), "Данные о песещениях отсутствуют", Toast.LENGTH_SHORT).show();

    }

    private String getDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd");
        return dateFormat.format(currentDate);
    }

    private String getMonth() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("MM");
        String monthNumber = dateFormat.format(currentDate);
        String monthName = "";

        switch (monthNumber) {
            case "01":
                monthName = "январ";
                break;
            case "02":
                monthName = "феврал";
                break;
            case "03":
                monthName = "март";
                break;
            case "04":
                monthName = "апрел";
                break;
            case "05":
                monthName = "ма";
                break;
            case "06":
                monthName = "июн";
                break;
            case "07":
                monthName = "июл";
                break;
            case "08":
                monthName = "август";
                break;
            case "09":
                monthName = "сентябр";
                break;
            case "10":
                monthName = "октябр";
                break;
            case "11":
                monthName = "ноябр";
                break;
            case "12":
                monthName = "декабр";
                break;
            default:
                monthName = "неверный месяц"; // Обработка неверных значений
        }

        if (monthNumber.equals("02") || monthNumber.equals("07") || monthNumber.equals("12")) {
            monthName += "я";
        } else {
            if(!monthNumber.equals("03"))
             monthName += "ь";
        }

        return monthName;
    }

    @Override
    public void showMessage(String msg) {
        Toast.makeText(getContext(), msg, Toast.LENGTH_SHORT).show();
    }
}
