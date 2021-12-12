package com.example.navigationdrawer.ui.radix;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.navigationdrawer.databinding.CalculatorRadixBinding;

public class CalculatorRadix extends Fragment {

    public static final char CHAR_55 = 55;

    private RadixViewModel galleryViewModel;
    private CalculatorRadixBinding binding;

    private EditText input;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        galleryViewModel =
                new ViewModelProvider(this).get(RadixViewModel.class);

        binding = CalculatorRadixBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

//        final TextView textView = binding.textGallery;
//        galleryViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        binding.buttonTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                input = binding.editCoSo10;
                String coso2 = convertNumber(Integer.parseInt(input.getText().toString()),2);
                String coso16 = convertNumber(Integer.parseInt(input.getText().toString()),16);
                binding.textCoSo2.setText(coso2);
                binding.textCoSo16.setText(coso16);
            }
        });

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public static String convertNumber(int n, int b) {
        if (n < 0 || b < 2 || b > 16 ) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        int m;
        int remainder = n;

        while (remainder > 0) {
            if (b > 10) {
                m = remainder % b;
                if (m >= 10) {
                    sb.append((char) ( CHAR_55 + m));
                } else {
                    sb.append(m);
                }
            } else {
                sb.append(remainder % b);
            }
            remainder = remainder / b;
        }
        return sb.reverse().toString();
    }
}