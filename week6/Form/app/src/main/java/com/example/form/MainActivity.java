package com.example.form;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText editname = findViewById(R.id.nameedit);
        EditText editmssv = findViewById(R.id.editmssv);
        EditText editday = findViewById(R.id.editday);
        EditText editemail = findViewById(R.id.editemail);
        EditText editnumber = findViewById(R.id.editnumber);

        Button button = findViewById(R.id.button);


        editname.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editname.getText().toString().isEmpty() || editmssv.getText().toString().isEmpty()
                        || editday.getText().toString().isEmpty() || editemail.getText().toString().isEmpty()
                        || editnumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }else {
                    button.setEnabled(true);
                }
            }
        });

        editmssv.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editname.getText().toString().isEmpty() || editmssv.getText().toString().isEmpty()
                        || editday.getText().toString().isEmpty() || editemail.getText().toString().isEmpty()
                        || editnumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }else {
                    button.setEnabled(true);
                }
            }
        });

        editday.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editname.getText().toString().isEmpty() || editmssv.getText().toString().isEmpty()
                        || editday.getText().toString().isEmpty() || editemail.getText().toString().isEmpty()
                        || editnumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }else {
                    button.setEnabled(true);
                }
            }
        });

        editemail.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editname.getText().toString().isEmpty() || editmssv.getText().toString().isEmpty()
                        || editday.getText().toString().isEmpty() || editemail.getText().toString().isEmpty()
                        || editnumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }else {
                    button.setEnabled(true);
                }
            }
        });

        editnumber.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                if(editname.getText().toString().isEmpty() || editmssv.getText().toString().isEmpty()
                        || editday.getText().toString().isEmpty() || editemail.getText().toString().isEmpty()
                        || editnumber.getText().toString().isEmpty()){
                    Toast.makeText(MainActivity.this, "Vui long dien day du thong tin", Toast.LENGTH_SHORT).show();
                    button.setEnabled(false);
                }else {
                    button.setEnabled(true);
                }
            }
        });

    }
}