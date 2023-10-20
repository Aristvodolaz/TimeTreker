package com.example.timetrekerforandroid.fragment.head;

import android.widget.Button;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.dialog.ChooseCorpusVhodDialog;
import com.example.timetrekerforandroid.dialog.ChooseCorpusVyhodDialog;
import com.example.timetrekerforandroid.fragment.BaseFragment;

import butterknife.BindView;

public class StartFragment extends BaseFragment {
    public static StartFragment newInstance() {
        return new StartFragment();
    }

    @BindView(R.id.vhod) Button vhod;

    @BindView(R.id.vyhod) Button vyhod;
    @Override
    protected void initViews() {
        super.initViews();
        vhod.setOnClickListener(l->{
            ChooseCorpusVhodDialog dialog = new ChooseCorpusVhodDialog();
            dialog.setCancelable(true);
            dialog.show(getChildFragmentManager(),"lol");
        });
        vyhod.setOnClickListener(l->{
            ChooseCorpusVyhodDialog dialog = new ChooseCorpusVyhodDialog();
            dialog.setCancelable(true);
            dialog.show(getChildFragmentManager(),"lol");
        });
    }

    @Override
    protected int layoutId() {
        return R.layout.head_start_fragment;
    }
}
