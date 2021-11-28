package com.example.spinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    String[] to = {"US", "VND", "Nhân dân tệ"};
    Double[][] value = {{1.0,1/22679D,6.39},{22679D,1.0,1/3547.47},{1/6.39,3547.47,1.0}};
    Spinner spinnerto;
    Spinner spinnerFrom;
    EditText numberFrom;
    int column;
    int row;
    Button chuyenButton;
    EditText numberTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinnerto = findViewById(R.id.spinnerTo);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        numberFrom = findViewById(R.id.numberFrom);

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, to);
        spinnerto.setAdapter(arrayAdapter);
        spinnerto.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "COLUMN: "+ position);
                row = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        spinnerFrom.setAdapter(arrayAdapter);
        spinnerFrom.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Log.d("TAG", "ROW: "+ position);
                column = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        numberTo = findViewById(R.id.numberTo);
        chuyenButton = findViewById(R.id.chuyenButton);
        chuyenButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.d("TAG", "afterTextChanged: " + numberTo.getText().toString());
                String textResult;
                Double result ;
                try {
                    Log.d("TAG", "value = " + value[column][row]);
                    result = Double.parseDouble(numberTo.getText().toString())*value[column][row];
                    textResult = String.valueOf(result);
//                    textResult = textResult.substring(0,textResult.length()-2);
                    numberFrom.setText(textResult);
                }catch (Exception e){
                    numberFrom.setText("");
                }
            }
        });

    }
}