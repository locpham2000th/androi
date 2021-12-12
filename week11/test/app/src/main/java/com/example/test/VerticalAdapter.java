package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class VerticalAdapter extends RecyclerView.Adapter<VerticalAdapter.VerticalViewHolder> {

    List<List<ItemModel>> itemss;

    public VerticalAdapter(List<List<ItemModel>> itemss) {
        this.itemss = itemss;
    }

    @NonNull
    @Override
    public VerticalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_vertical,parent,false);
        return new VerticalViewHolder(view) ;
    }

    @Override
    public void onBindViewHolder(@NonNull VerticalViewHolder holder, int position) {
        List<ItemModel> items = itemss.get(position);
        HorizontalAdapter adapter = new HorizontalAdapter(items);

        holder.horizontalList.setHasFixedSize(true);
        holder.horizontalList.setLayoutManager(new LinearLayoutManager(holder.horizontalList.getContext(), LinearLayoutManager.HORIZONTAL, false));
        holder.horizontalList.setAdapter(adapter);
    }

    @Override
    public int getItemCount() {
        return itemss.size();
    }

    class VerticalViewHolder extends RecyclerView.ViewHolder{

        RecyclerView horizontalList;

        public VerticalViewHolder(@NonNull View itemView) {
            super(itemView);

            horizontalList = itemView.findViewById(R.id.horizontal_list);
        }
    }
}
