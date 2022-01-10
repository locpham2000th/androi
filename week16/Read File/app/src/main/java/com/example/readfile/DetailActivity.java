package com.example.readfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        listView = findViewById(R.id.list_view_detail);

        List<String> item = new ArrayList<>();

        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String path = intent.getStringExtra("path");
        Log.v("TAG", name);
        Log.v("TAG", path);

        File file = new File(path);
        File[] files = file.listFiles();
        Log.v("TAG", "số phần tử trong file là : " + files.length);
        for (File f : files){
            Log.v("TAG", f.getName());
            item.add(f.getName());
        }

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.support_simple_spinner_dropdown_item, item);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(files[position].isFile()) {
                    try {
                        FileInputStream fis = openFileInput(path + "/" + item.get(position));
                        BufferedReader reader = new BufferedReader(new InputStreamReader(fis));
                        String line;
                        StringBuilder builder = new StringBuilder();
                        while ((line = reader.readLine()) != null)
                            builder.append(line + "\n");
                        reader.close();
                        Intent intent = new Intent(DetailActivity.this, ContentActivity.class);
                        intent.putExtra("content", builder.toString());
                        DetailActivity.this.startActivities(new Intent[]{intent});
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

    }
}