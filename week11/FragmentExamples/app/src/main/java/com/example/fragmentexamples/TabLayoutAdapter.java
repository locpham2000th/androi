package com.example.fragmentexamples;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

public class TabLayoutAdapter extends FragmentStateAdapter {

    public TabLayoutAdapter(@NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        if (position == 0)
            return BlueFragment.newInstance();
        else if (position == 1)
            return  RedFragment.newInstance();
        else
            return PageFragment.newInstance("Test");
    }

    @Override
    public int getItemCount() {
        return 3;
    }
}
