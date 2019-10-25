package com.example.tawazonanimations;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

public class CollectionAdapter extends FragmentStatePagerAdapter {
    public CollectionAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        MyFragment fragment=new MyFragment();
        Bundle bundle=new Bundle();
        bundle.putString("Name","background"+(position+1));
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public int getCount() {
        return 3;
    }
}
