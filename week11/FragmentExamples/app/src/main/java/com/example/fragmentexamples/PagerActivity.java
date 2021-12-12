package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

public class PagerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pager);

        List<String> pages = new ArrayList<>();
        for (int i = 0; i < 10; i++)
            pages.add("Page "+ (i + 1));

        ViewPager2 viewPager = findViewById(R.id.view_pager);
        PageAdapter adapter = new PageAdapter(this, pages);
        viewPager.setAdapter(adapter);
    }
}