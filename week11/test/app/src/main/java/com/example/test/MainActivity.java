package com.example.test;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    List<ItemModel> items;
    ItemAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        items.add(new ItemModel("Title1", R.drawable.thumb1));
        items.add(new ItemModel("Title10", R.drawable.thumb10));
        items.add(new ItemModel("Title11", R.drawable.thumb11));
        items.add(new ItemModel("Title12", R.drawable.thumb12));
        items.add(new ItemModel("Title13", R.drawable.thumb13));
        items.add(new ItemModel("Title14", R.drawable.thumb14));
        items.add(new ItemModel("Title15", R.drawable.thumb15));
        items.add(new ItemModel("Title16", R.drawable.thumb16));
        items.add(new ItemModel("Title17", R.drawable.thumb17));
        items.add(new ItemModel("Title1", R.drawable.thumb1));
        items.add(new ItemModel("Title10", R.drawable.thumb10));
        items.add(new ItemModel("Title11", R.drawable.thumb11));
        items.add(new ItemModel("Title12", R.drawable.thumb12));
        items.add(new ItemModel("Title13", R.drawable.thumb13));

        adapter = new ItemAdapter(items, this);

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
//        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, true);
//        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(this,2);
//        RecyclerView.LayoutManager layoutManager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setAdapter(adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

        ItemTouchHelper.SimpleCallback callback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                items.remove(position);
                adapter.notifyItemRemoved(position);
            }
        };

        ItemTouchHelper touchHelper = new ItemTouchHelper(callback);
        touchHelper.attachToRecyclerView(recyclerView);

        findViewById(R.id.button_remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(1);
                adapter.notifyItemRemoved(1);
            }
        });

        findViewById(R.id.button_update).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.get(1).setTitle("Updated");
                adapter.notifyItemChanged(1);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Log.v("TAG", items.get(position).getTitle() + " is clicked");
    }
}