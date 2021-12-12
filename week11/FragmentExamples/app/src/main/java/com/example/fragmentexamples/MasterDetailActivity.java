package com.example.fragmentexamples;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MasterDetailActivity extends AppCompatActivity implements ItemClickListener {

    BlueFragment blueFragment;
    RedFragment redFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_master_detail);

        blueFragment = BlueFragment.newInstance();
        redFragment = RedFragment.newInstance();

        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.master_layout,blueFragment);
        ft.commit();

        if (findViewById(R.id.detail_layout) != null){
            ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.detail_layout,redFragment);
            ft.commit();
        }

    }

    @Override
    public void onItemClick(String item) {
        if (findViewById(R.id.detail_layout) != null) {
            redFragment.updateContent(item);
        }else {
            Bundle bundle = new Bundle();
            bundle.putString("param", item);
            redFragment.setArguments(bundle);

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.add(R.id.master_layout,redFragment);
            ft.addToBackStack("detail");
            ft.commit();
        }
    }
}