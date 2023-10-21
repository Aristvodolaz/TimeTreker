package com.example.timetrekerforandroid.fragment.user;

import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.fragment.BaseFragment;
import com.example.timetrekerforandroid.presenter.GetProfileTimePresenter;
import com.example.timetrekerforandroid.util.SPHelper;
import com.example.timetrekerforandroid.view.GetProfileTimeView;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import butterknife.BindView;

public class UserStartFragment extends BaseFragment implements GetProfileTimeView {
    public static final String LOGIN ="login";
    @BindView(R.id.name) TextView name;
    @BindView(R.id.time_start) LinearLayout startLine;
    @BindView(R.id.group) TextView group;
    @BindView(R.id.cafedra) TextView cafedra;
    @BindView(R.id.institute) TextView institute;
    @BindView(R.id.time_start_tv) TextView startTime;
    @BindView(R.id.btn_refresh)
    FrameLayout btnRefresh;
    @BindView(R.id.image_refresh)
    ImageView imageRefresh;

    public GetProfileTimePresenter presenter;
    private ValueAnimator rotateAnimator;
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

        presenter = new GetProfileTimePresenter(this);
        presenter.getInfoTime(SPHelper.getLogin(), getDate());

        btnRefresh.setOnClickListener(l->{
            startRotationAnimation();
            presenter.getInfoTime(SPHelper.getLogin(), getDate());
        });

        name.setText(SPHelper.getName()+" "+ SPHelper.getSurname());
        group.setText(SPHelper.getGroup());
        cafedra.setText(SPHelper.getCafedra());
        institute.setText(SPHelper.getInstitute());
    }
    private void startRotationAnimation() {
        rotateAnimator = ValueAnimator.ofFloat(0, 360);
        rotateAnimator.setInterpolator(new LinearInterpolator());
        rotateAnimator.setDuration(1000);
        rotateAnimator.setRepeatCount(ValueAnimator.INFINITE);
        rotateAnimator.addUpdateListener(valueAnimator -> {
            float rotation = (float) valueAnimator.getAnimatedValue();
            imageRefresh.setRotation(rotation);
        });
        rotateAnimator.start();
    }

    private void stopRotationAnimation() {
        if (rotateAnimator != null && rotateAnimator.isRunning()) {
            rotateAnimator.cancel();
        }
    }

    private String getDate() {
        Date currentDate = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd.mm.yyyy");
        return dateFormat.format(currentDate);
    }
    @Override
    protected int layoutId() {
        return R.layout.user_fragment;
    }

    @Override
    public void getTimeinfo(String time) {
        stopRotationAnimation();
        if(time.equals("0")) startLine.setVisibility(View.GONE);
        else startTime.setText(time);
    }
}
