package com.example.qyh.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by qyh on 2016/11/17.
 */

public class NumberAdapter extends RecyclerView.Adapter<NumberAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<Character> datas;

    public NumberAdapter(Context context,List datas){
        this.datas = new ArrayList<>();
        this.datas.clear();
        this.datas.addAll(datas);
        inflater = LayoutInflater.from(context);
    }
    public static class ViewHolder extends RecyclerView.ViewHolder{
        public ViewHolder(View view){
            super(view);
        }
        TextView textView;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.inflate_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        holder.textView = (TextView) view.findViewById(R.id.textview_items);
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.textView.setText(datas.get(position)+"");
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }
}
