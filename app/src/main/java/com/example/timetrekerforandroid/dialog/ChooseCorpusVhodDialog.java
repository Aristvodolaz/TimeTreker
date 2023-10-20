package com.example.timetrekerforandroid.dialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.activity.HeadActivity;
import com.example.timetrekerforandroid.fragment.head.GenerationQrForVhodFragment;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class ChooseCorpusVhodDialog extends BottomSheetDialogFragment {
    LinearLayout first, second;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = LayoutInflater.from(getContext()).inflate(R.layout.choose_bottom_dialog, container, false);

        first = v.findViewById(R.id.first);
        second = v.findViewById(R.id.second);

        first.setOnClickListener(l->{
            ((HeadActivity)getActivity()).replaceFragment(GenerationQrForVhodFragment.newInstance(true), true);
        });
        second.setOnClickListener(l->{
            ((HeadActivity)getActivity()).replaceFragment(GenerationQrForVhodFragment.newInstance(false), true);
        });

        return v;
    }

}
