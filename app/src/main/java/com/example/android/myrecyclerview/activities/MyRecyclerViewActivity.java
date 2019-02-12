package com.example.android.myrecyclerview.activities;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.android.myrecyclerview.R;

public class MyRecyclerViewActivity extends MyBaseRecyclerViewActivity {

    public static final String TAG = "MyRecyclerViewActivity";

    // Is the log fragment is currently shown
    private boolean isLogShown =  false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        if(savedInstanceState == null){
            FragmentManager fragMgr  = getSupportFragmentManager();
            FragmentTransaction fragTrx = fragMgr.beginTransaction();

        }
    }
}
