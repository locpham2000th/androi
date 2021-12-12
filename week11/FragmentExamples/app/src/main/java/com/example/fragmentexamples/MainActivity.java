package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements ItemClickListener {

    BlueFragment blueFragment;
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blueFragment = BlueFragment.newInstance();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_blue,blueFragment);
        ft.commit();

        redFragment = RedFragment.newInstance();
        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.layout_red,redFragment);
        ft.commit();

    }

    @Override
    public void onItemClick(String item) {
        redFragment.updateContent(item);
    }
}