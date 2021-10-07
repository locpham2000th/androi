package com.example.helloconstraint;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private Button buttonZero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mShowCount = (TextView) findViewById(R.id.show_count);
        buttonZero = (Button) findViewById(R.id.rezo_button);
    }

    public void showToast(View view) {
        Toast toast = Toast.makeText(this, R.string.toast_message, Toast.LENGTH_SHORT);
        toast.show();
    }

    @SuppressLint("ResourceAsColor")
    public void countUp(View view) {
        ++mCount;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
        if(mCount % 2 == 0){
            buttonZero.setTextColor(R.color.purple_200);
        }else {
            buttonZero.setTextColor(R.color.black);
        }
    }

    @SuppressLint("ResourceAsColor")
    public void zeroValue(View view) {
        mCount = 0;
        if(mShowCount != null){
            mShowCount.setText("0");
            buttonZero.setTextColor(R.color.purple_200);
        }
    }
}