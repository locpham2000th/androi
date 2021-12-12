package com.example.fragmentexamples;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import java.util.List;

public class PageAdapter extends FragmentStateAdapter {

    List<String> pages;



    public PageAdapter(@NonNull FragmentActivity fragmentActivity, List<String> pages) {
        super(fragmentActivity);
        this.pages = pages;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        return PageFragment.newInstance(pages.get(position));
    }

    @Override
    public int getItemCount() {
        return pages.size();
    }
}
