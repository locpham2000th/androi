package com.example.gmail;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends BaseAdapter {

    List<ItemModel> items;

    public ItemAdapter(List<ItemModel> items) {
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int position) {
        return items.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_item_layout, null);
            viewHolder = new ViewHolder();
            viewHolder.imageView = convertView.findViewById(R.id.image_avata);
            viewHolder.textName = convertView.findViewById(R.id.name);
            viewHolder.textContent = convertView.findViewById(R.id.content);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

            ItemModel item  = items.get(position);
            viewHolder.imageView.setImageResource(item.getAvata());
            viewHolder.textName.setText(item.getName());
            viewHolder.textContent.setText(item.getContent());

            return convertView;

    }

    private class ViewHolder{
        public ImageView imageView;
        public TextView textName;
        public TextView textContent;
    }

}
