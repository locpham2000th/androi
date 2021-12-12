package com.example.navigationdrawer.ui.math;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.databinding.CalculatorMathBinding;

public class CalculatorMath extends Fragment implements View.OnClickListener {

    private MathViewModel homeViewModel;
    private CalculatorMathBinding binding;

    static TextView input;
    TextView result;
    static String phepTinh;

    //Các biến
    static int var1;
    static int var2;
    int rs;
    static String dau = "";

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                new ViewModelProvider(this).get(MathViewModel.class);

        binding = CalculatorMathBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textHome;
//        homeViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        input = binding.input;
        result = binding.result;
        phepTinh = input.getText().toString();

        binding.one.setOnClickListener(this);
        binding.two.setOnClickListener(this);
        binding.three.setOnClickListener(this);
        binding.four.setOnClickListener(this);
        binding.five.setOnClickListener(this);
        binding.six.setOnClickListener(this);
        binding.seven.setOnClickListener(this);
        binding.eight.setOnClickListener(this);
        binding.nine.setOnClickListener(this);
        binding.zero.setOnClickListener(this);

        binding.CE.setOnClickListener(this);
        binding.C.setOnClickListener(this);
        binding.remove.setOnClickListener(this);

        binding.nhan.setOnClickListener(this);
        binding.cong.setOnClickListener(this);
        binding.tru.setOnClickListener(this);
        binding.chia.setOnClickListener(this);
        binding.bang.setOnClickListener(this);

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    @Override
    public void onClick(View v) {
        Log.d("TAG", "onClick: ");
        int id = v.getId();
        if (binding.one.getId() == id){
            writeNumber(1);
        }
        if (binding.two.getId() == id){
            writeNumber(2);
        }
        if (binding.three.getId() == id){
            writeNumber(3);
        }
        if(binding.four.getId() == id)
                writeNumber(4);
        if (binding.five.getId() == id){
            writeNumber(5);
        }
        if (binding.six.getId() == id){
            writeNumber(6);
        }
        if (binding.seven.getId() == id){
            writeNumber(7);
        }
        if(binding.eight.getId() == id)
            writeNumber(8);
        if (binding.nine.getId() == id)
            writeNumber(9);
        if (binding.zero.getId() == id){
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
        }
        if (binding.C.getId() == id){
            phepTinh = "";
            input.setText("");
            result.setText("");
            var1 = 0;
            var2 = 0;
            rs = 0;
        }
        if(binding.CE.getId() == id){
            if(dau == ""){
                var1 = 0;
            }else {
                var2 = 0;
            }
            input.setText("");
            phepTinh = "";
        }
        if (binding.nhan.getId() == id){
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
        }
        if (binding.cong.getId() == id){
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
        }
        if(binding.tru.getId() == id){
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
        }
        if(binding.chia.getId() == id){
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
        }
        if(binding.bang.getId() == id){
            int ketqua = calculator(var1, var2, dau);
            input.setText(String.valueOf(ketqua));
            phepTinh = "";
            dau = "";
        }
        if(binding.remove.getId() == id){
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