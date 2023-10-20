package com.example.timetrekerforandroid.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.timetrekerforandroid.R;
import com.example.timetrekerforandroid.db.UserTimeData;

import java.util.List;

public class InfoTimeAdapter extends RecyclerView.Adapter<InfoTimeAdapter.LabelHolder> {
    public List<UserTimeData> data;
    public Context context;

    public InfoTimeAdapter(List<UserTimeData> data, Context context) {
        this.data = data;
        this.context = context;
    }

    @NonNull
    @Override
    public InfoTimeAdapter.LabelHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_info, parent, false);
        return new LabelHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull InfoTimeAdapter.LabelHolder holder, int position) {
        holder.date.setText(data.get(position).getData());
        holder.corpus.setText(data.get(position).getCorpus());
//        holder.full_time.setText(Integer.parseInt(data.get(position).getVyhod())-Integer.parseInt(data.get(position).getVhod())+"");
        holder.ot_do.setText(data.get(position).getVhod() +" ... "+ data.get(position).getVyhod());
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class LabelHolder extends RecyclerView.ViewHolder {

        TextView date, corpus, full_time,  ot_do;
        public LabelHolder(@NonNull View itemView) {
            super(itemView);

            date = itemView.findViewById(R.id.date);
            corpus = itemView.findViewById(R.id.corpus);
            full_time = itemView.findViewById(R.id.full_time);
            ot_do = itemView.findViewById(R.id.ot_do);
        }
    }
}
