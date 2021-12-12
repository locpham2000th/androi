package com.example.fragmentexamples;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RedFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RedFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    static int fragmentIndex = 0;

    public RedFragment() {
        // Required empty public constructor
    }

    public static RedFragment newInstance() {
        return new RedFragment();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView textView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_red, container, false);

        textView = view.findViewById(R.id.text_view);
//        textView.setText(mParam1 + "-" + mParam2);

//        fragmentIndex++;
//        textView.setText(fragmentIndex+ "");

        Bundle bundle = getArguments();
        if (bundle != null){
            String item = bundle.getString("param");
            if (item != null)
                textView.setText(item);
        }

        return view;
    }

    public void updateContent(String content){
        textView.setText(content);
    }
}