package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);

        findViewById(R.id.button_add_blue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BlueFragment blueFragment = BlueFragment.newInstance();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.fragment_layout, blueFragment);
                ft.commit();
            }
        });

        findViewById(R.id.button_add_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedFragment redFragment = RedFragment.newInstance();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.add(R.id.fragment_layout, redFragment, "RED");
                ft.addToBackStack("RED");
                ft.commit();
            }
        });

        findViewById(R.id.button_replace).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RedFragment redFragment = RedFragment.newInstance();
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.fragment_layout, redFragment);
                ft.addToBackStack("RED");
                ft.commit();
            }
        });

        findViewById(R.id.button_pop_fragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getSupportFragmentManager().popBackStackImmediate();
            }
        });

        findViewById(R.id.button_remove_red).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment redFragment = getSupportFragmentManager().findFragmentByTag("RED");
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.remove(redFragment);
                ft.commit();
            }
        });


    }
}