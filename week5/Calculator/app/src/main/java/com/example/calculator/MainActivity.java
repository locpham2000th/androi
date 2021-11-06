package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    static TextView input;
    TextView result;
    static String phepTinh;

    //Các biến
    static int var1;
    static int var2;
    int rs;
    static String dau = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        input = findViewById(R.id.input);
        result = findViewById(R.id.result);
        phepTinh = input.getText().toString();
        findViewById(R.id.one).setOnClickListener(this);
        findViewById(R.id.two).setOnClickListener(this);
        findViewById(R.id.three).setOnClickListener(this);
        findViewById(R.id.four).setOnClickListener(this);
        findViewById(R.id.five).setOnClickListener(this);
        findViewById(R.id.six).setOnClickListener(this);
        findViewById(R.id.seven).setOnClickListener(this);
        findViewById(R.id.eight).setOnClickListener(this);
        findViewById(R.id.nine).setOnClickListener(this);
        findViewById(R.id.zero).setOnClickListener(this);

        //chức năng
        findViewById(R.id.CE).setOnClickListener(this);
        findViewById(R.id.C).setOnClickListener(this);
        findViewById(R.id.remove).setOnClickListener(this);

        //phép tính
        findViewById(R.id.nhan).setOnClickListener(this);
        findViewById(R.id.cong).setOnClickListener(this);
        findViewById(R.id.tru).setOnClickListener(this);
        findViewById(R.id.chia).setOnClickListener(this);
        findViewById(R.id.bang).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Log.d("TAG", "onClick: ");
        int id = view.getId();
        switch (id){
            case R.id.one:
                writeNumber(1);
                break;
            case R.id.two:
                writeNumber(2);
                break;
            case R.id.three:
                writeNumber(3);
                break;
            case R.id.four:
                writeNumber(4);
                break;
            case R.id.five:
                writeNumber(5);
                break;
            case R.id.six:
                writeNumber(6);
                break;
            case R.id.seven:
                writeNumber(7);
                break;
            case R.id.eight:
                writeNumber(8);
                break;
            case R.id.nine:
                writeNumber(9);
                break;
            case R.id.zero:
                if(dau == ""){
                    if(phepTinh != "" && phepTinh != "0"){
                        phepTinh += "0";
                        var1 = Integer.parseInt(phepTinh);
                        input.setText(String.valueOf(var1));
                    }else {
                        phepTinh = "0";
                        input.setText("0");
                        var1 = 0;
                    }
                }else {
                    if(phepTinh != "" && phepTinh != "0"){
                        phepTinh += "0";
                        var2 = Integer.parseInt(phepTinh);
                        input.setText(String.valueOf(var2));
                    }else {
                        phepTinh = "0";
                        input.setText("0");
                        var2 = 0;
                    }
                }
                break;
            case R.id.C:
                phepTinh = "";
                input.setText("");
                result.setText("");
                var1 = 0;
                var2 = 0;
                rs = 0;
                break;
            case R.id.CE:
                if(dau == ""){
                    var1 = 0;
                }else {
                    var2 = 0;
                }
                input.setText("");
                phepTinh = "";
                break;
            case R.id.nhan:
                if(dau == ""){
                    dau = "nhan";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(var1) + "x");
                }else {
                    int ketqua = calculator(var1, var2, dau);
                    var1 = ketqua;
                    dau = "nhan";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(ketqua)+ "x");
                }
                break;
            case R.id.cong:
                if(dau == ""){
                    dau = "cong";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(var1) + "+");
                }else {
                    int ketqua = calculator(var1, var2, dau);
                    var1 = ketqua;
                    dau = "cong";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(ketqua)+ "+");
                }
                break;
            case R.id.tru:
                if(dau == ""){
                    dau = "tru";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(var1) + "-");
                }else {
                    int ketqua = calculator(var1, var2, dau);
                    var1 = ketqua;
                    dau = "tru";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(ketqua)+ "-");
                }
                break;
            case R.id.chia:
                if(dau == ""){
                    dau = "chia";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(var1) + "/");
                }else {
                    int ketqua = calculator(var1, var2, dau);
                    var1 = ketqua;
                    dau = "chia";
                    input.setText("");
                    phepTinh = input.getText().toString();
                    result.setText(String.valueOf(ketqua)+ "/");
                }
                break;
            case R.id.bang:
                int ketqua = calculator(var1, var2, dau);
                input.setText(String.valueOf(ketqua));
                phepTinh = "";
                dau = "";
                break;
            case R.id.remove:
                if(dau == ""){
                    if(phepTinh.length() != 1){
                        phepTinh = phepTinh.substring(0, phepTinh.length() -1);
                        var1 = Integer.parseInt(phepTinh);
                    }else {
                        phepTinh = "";
                        var1 = 0;
                    }
                    input.setText(phepTinh);
                }else {
                    if(phepTinh.length() != 1){
                        phepTinh = phepTinh.substring(0, phepTinh.length() -1);
                        var2 = Integer.parseInt(phepTinh);
                    }else {
                        phepTinh = "";
                        var2 = 0;
                    }
                    input.setText(phepTinh);
                }
                break;
        }
    }

    public int calculator(int var1, int var2, String dau){
        int rs = 0;
        switch (dau){
            case "cong":
                rs = var1 + var2;
                result.setText(String.valueOf(var1) + "+" + String.valueOf(var2) + "=");
                break;
            case "tru":
                rs = var1 - var2;
                result.setText(String.valueOf(var1) + "-" + String.valueOf(var2) + "=");
                break;
            case "nhan":
                rs = var1 * var2;
                result.setText(String.valueOf(var1) + "x" + String.valueOf(var2) + "=");
                break;
            case "chia":
                try {
                    rs = var1 / var2;
                    result.setText(String.valueOf(var1) + "/" + String.valueOf(var2) + "=");
                }catch (ArithmeticException e){
                    result.setText("Lỗi chia cho 0");
                    phepTinh = "";
                    input.setText("");
                }

                break;
        }

        return rs;
    }

    public static String removeCharAt(String s, int pos){
        return s.substring(0,pos) + s.substring(pos + 1);
    }

    public static void writeNumber(int number){
        if(input.getText() != "" ){
            if(dau != ""){
                phepTinh = input.getText().toString();
                phepTinh += String.valueOf(number);
                var2 = Integer.parseInt(phepTinh);
                input.setText(phepTinh);
            }else {
                phepTinh += String.valueOf(number);
                var1 = Integer.parseInt(phepTinh);
                input.setText(phepTinh);
            }
        }else {
            if(dau != ""){
                input.setText(String.valueOf(number));
                var2 = number;
            }else {
                input.setText(String.valueOf(number));
                var1 = Integer.parseInt(input.getText().toString());
            }
            phepTinh = String.valueOf(number);
        }
    }
}