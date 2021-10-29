package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    TextView input;
    String phepTinh;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        phepTinh = input.getText().toString();
//        Log.d("TAG", "onCreate: " + phepTinh);
        findViewById(R.id.one).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Log.d("TAG", "onClick: ");
        int id = view.getId();
        if(id == R.id.one){
            phepTinh += "1";
            input.setText(phepTinh);
        }
    }
}