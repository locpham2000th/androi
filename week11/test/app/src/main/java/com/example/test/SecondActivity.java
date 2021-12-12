package com.example.test;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class SecondActivity extends AppCompatActivity {

    List<List<ItemModel>> itemss;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        itemss = new ArrayList<>();
        itemss.add(new ArrayList<>());
        itemss.get(0).add(new ItemModel("Title11", R.drawable.thumb1));
        itemss.get(0).add(new ItemModel("Title12", R.drawable.thumb2));
        itemss.get(0).add(new ItemModel("Title13", R.drawable.thumb3));
        itemss.get(0).add(new ItemModel("Title14", R.drawable.thumb4));
        itemss.get(0).add(new ItemModel("Title15", R.drawable.thumb5));
        itemss.add(new ArrayList<>());
        itemss.get(1).add(new ItemModel("Title21", R.drawable.thumb6));
        itemss.get(1).add(new ItemModel("Title22", R.drawable.thumb7));
        itemss.get(1).add(new ItemModel("Title23", R.drawable.thumb8));
        itemss.get(1).add(new ItemModel("Title24", R.drawable.thumb9));
        itemss.get(1).add(new ItemModel("Title25", R.drawable.thumb10));
        itemss.add(new ArrayList<>());
        itemss.get(2).add(new ItemModel("Title31", R.drawable.thumb11));
        itemss.get(2).add(new ItemModel("Title32", R.drawable.thumb12));
        itemss.get(2).add(new ItemModel("Title33", R.drawable.thumb13));
        itemss.get(2).add(new ItemModel("Title34", R.drawable.thumb14));
        itemss.get(2).add(new ItemModel("Title35", R.drawable.thumb15));
        itemss.add(new ArrayList<>());
        itemss.get(3).add(new ItemModel("Title41", R.drawable.thumb16));
        itemss.get(3).add(new ItemModel("Title42", R.drawable.thumb17));
        itemss.get(3).add(new ItemModel("Title43", R.drawable.thumb18));
        itemss.get(3).add(new ItemModel("Title44", R.drawable.thumb19));
        itemss.get(3).add(new ItemModel("Title45", R.drawable.thumb20));
        itemss.add(new ArrayList<>());
        itemss.get(4).add(new ItemModel("Title51", R.drawable.thumb21));
        itemss.get(4).add(new ItemModel("Title52", R.drawable.thumb22));
        itemss.get(4).add(new ItemModel("Title53", R.drawable.thumb23));
        itemss.get(4).add(new ItemModel("Title54", R.drawable.thumb24));
        itemss.get(4).add(new ItemModel("Title55", R.drawable.thumb25));

        RecyclerView verticalList = findViewById(R.id.vertical_list);
        verticalList.setHasFixedSize(true);
        verticalList.setLayoutManager(new LinearLayoutManager(this));
        verticalList.setAdapter(new VerticalAdapter(itemss));

    }
}