package com.shimy.nestscroll.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shimy.nestscroll.R;
import com.shimy.nestscroll.bean.Test;

import java.util.List;

public class TestAdapter extends RecyclerView.Adapter<TestAdapter.TestHolder> {

    private Context context;
    private List<Test> list;

    public TestAdapter(Context context, List<Test> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TestHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_test, parent, false);
        return new TestHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TestHolder holder, int position) {
        holder.tvWord1.setText(list.get(position).getWord1());
        holder.tvWord2.setText(list.get(position).getWord2());
    }

    @Override
    public int getItemCount() {
        return list != null ? list.size() : 0;
    }

    class TestHolder extends RecyclerView.ViewHolder {

        TextView tvWord1;
        TextView tvWord2;

        public TestHolder(View itemView) {
            super(itemView);
            tvWord1 = itemView.findViewById(R.id.tv_word1);
            tvWord2 = itemView.findViewById(R.id.tv_word2);
        }
    }
}
