package com.example.calculatecubicweight;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.calculatecubicweight.data.Objects;

import java.util.ArrayList;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {
    private ArrayList<Objects> mDataset;

    public MyAdapter(ArrayList<Objects> dataSet) {
        mDataset = dataSet;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.air_conditioner_item, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        holder.bind(position);
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        private TextView title;
        private TextView cubicWeight;

        public MyViewHolder(View view) {
            super(view);
            title = view.findViewById(R.id.title);
            cubicWeight = view.findViewById(R.id.cubic_weight);
        }

        public void bind(int lastIndex) {
            String titleText = mDataset.get(lastIndex).getTitle();
            String cubicWeightValue = String.valueOf(mDataset.get(lastIndex).getCubicWeight());
            title.setText(titleText);
            cubicWeight.setText(cubicWeightValue);
        }
    }
}
