package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class ChatLayoutActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_layout);

        items = new ArrayList<>();
        items.add(new ItemModel("Hello", R.drawable.thumb1, true));
        items.add(new ItemModel("Xin chao", R.drawable.thumb1, true));
        items.add(new ItemModel("Chao ban", R.drawable.thumb2, false));
        items.add(new ItemModel("Ban lam bai tap chua?", R.drawable.thumb2, false));
        items.add(new ItemModel("Minh lam het roi", R.drawable.thumb1, true));

        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(new ChatAdapter(items));
    }
}