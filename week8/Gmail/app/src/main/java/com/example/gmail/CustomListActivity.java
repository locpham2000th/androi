package com.example.gmail;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class CustomListActivity extends AppCompatActivity {

    List<ItemModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list);

        items = new ArrayList<>();
        items.add(new ItemModel(R.drawable.chul,"Lộc1","Lộc content1"));
        items.add(new ItemModel(R.drawable.chul,"Lộc2","Phúc content2"));
        items.add(new ItemModel(R.drawable.chul,"Lộc3","Lộc3 content3"));
        items.add(new ItemModel(R.drawable.chul,"Lộc4","Lộc content4"));
        items.add(new ItemModel(R.drawable.chul,"Lộc5","Lộc content5"));
        items.add(new ItemModel(R.drawable.chul,"Lộc6","Lộc content6"));
        items.add(new ItemModel(R.drawable.chul,"Lộc7","Lộc content7"));
        items.add(new ItemModel(R.drawable.chul,"Lộc8","Lộc content8"));
        items.add(new ItemModel(R.drawable.chul,"Lộc9","Lộc content9"));
        items.add(new ItemModel(R.drawable.chul,"Lộc10","Lộc content10"));
        items.add(new ItemModel(R.drawable.chul,"Lộc11","Lộc content11"));
        items.add(new ItemModel(R.drawable.chul,"Lộc12","Lộc content12"));
        items.add(new ItemModel(R.drawable.chul,"Lộc13","Lộc content13"));
        items.add(new ItemModel(R.drawable.chul,"Lộc14","Lộc content14"));
        items.add(new ItemModel(R.drawable.chul,"Lộc15","Lộc content15"));

        ItemAdapter adapter = new ItemAdapter(items);

        ListView listView = findViewById(R.id.list_view);
        listView.setAdapter(adapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}