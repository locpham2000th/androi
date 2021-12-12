package com.example.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChatAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    List<ItemModel> items;

    public ChatAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (viewType == 0) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_left, parent, false);
            return new LeftViewHolder(view);
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout_right, parent, false);
            return new RightViewHolder(view);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemModel item = items.get(position);
        if (getItemViewType(position) == 0) {
            ((LeftViewHolder)holder).imageAvatar.setImageResource(item.getAvatarResource());
            ((LeftViewHolder)holder).textMessage.setText(item.getTitle());
        } else {
            ((RightViewHolder)holder).imageAvatar.setImageResource(item.getAvatarResource());
            ((RightViewHolder)holder).textMessage.setText(item.getTitle());
        }
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    @Override
    public int getItemViewType(int position) {
        if (items.get(position).isLeft())
            return 0;
        else
            return 1;
    }

    class LeftViewHolder extends RecyclerView.ViewHolder {

        ImageView imageAvatar;
        TextView textMessage;

        public LeftViewHolder(@NonNull View itemView) {
            super(itemView);

            imageAvatar = itemView.findViewById(R.id.image_avatar);
            textMessage = itemView.findViewById(R.id.text_message);
        }
    }

    class RightViewHolder extends RecyclerView.ViewHolder {

        ImageView imageAvatar;
        TextView textMessage;

        public RightViewHolder(@NonNull View itemView) {
            super(itemView);

            imageAvatar = itemView.findViewById(R.id.image_avatar);
            textMessage = itemView.findViewById(R.id.text_message);
        }
    }
}
