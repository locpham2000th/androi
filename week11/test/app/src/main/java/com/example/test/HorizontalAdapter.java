package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class HorizontalAdapter extends RecyclerView.Adapter<HorizontalAdapter.HorizontalViewHolder> {

    List<ItemModel> items;

    public HorizontalAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public HorizontalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_horizontal, parent, false);
        return new HorizontalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HorizontalViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.imageAvatar.setImageResource(item.getAvatarResource());
        holder.textTitle.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class HorizontalViewHolder extends RecyclerView.ViewHolder{

        ImageView imageAvatar;
        TextView textTitle;

        public HorizontalViewHolder(@NonNull View itemView) {
            super(itemView);

            imageAvatar = itemView.findViewById(R.id.image_avata);
            textTitle = itemView.findViewById(R.id.text_title);

        }
    }

}
