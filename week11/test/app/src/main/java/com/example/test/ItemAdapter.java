package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ItemViewHolder>{

    List<ItemModel> items;
    ItemClickListener itemClickListener;

    public ItemAdapter(List<ItemModel> items, ItemClickListener itemClickListener) {
        this.items = items;
        this.itemClickListener = itemClickListener;
    }

    @NonNull
    @Override
    public ItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_1,parent,false);
        return new ItemViewHolder(view, itemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemViewHolder holder, int position) {
        ItemModel item = items.get(position);
        holder.textTitle.setText(item.getTitle());
        holder.imageAvata.setImageResource(item.getAvatarResource());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ItemViewHolder extends RecyclerView.ViewHolder{

        TextView textTitle;
        ImageView imageAvata;
        ItemClickListener _itemClickListener;

        public ItemViewHolder(@NonNull View itemView, ItemClickListener itemClickListener) {
            super(itemView);

            textTitle = itemView.findViewById(R.id.text_title);
            imageAvata = itemView.findViewById(R.id.image_avata);
            _itemClickListener = itemClickListener;

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(_itemClickListener != null)
                        _itemClickListener.onItemClick(getAdapterPosition());
                }
            });
        }
    }

}
