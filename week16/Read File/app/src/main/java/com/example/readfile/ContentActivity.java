package com.example.readfile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);

        TextView textView = findViewById(R.id.textViewContent);

        Intent intent = getIntent();
        String content = intent.getStringExtra("content");
        textView.setText(content);

    }
}