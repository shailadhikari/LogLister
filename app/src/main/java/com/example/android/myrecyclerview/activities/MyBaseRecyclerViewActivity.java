package com.example.android.myrecyclerview.activities;


import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.example.android.myrecyclerview.logging.Log;
import com.example.android.myrecyclerview.logging.LogWrapper;

public class MyBaseRecyclerViewActivity extends FragmentActivity {

    public static final String TAG = "MyBaseRecyclerViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        initLogging();
    }

    /**
     * Setup the targets to receive the logging data
     */
    public void initLogging(){

        // Using Log, front-end to the logging chain, emulates android.util.log method signatures.
        // Wraps Android's native log framework

        LogWrapper logWrapper = new LogWrapper();
        Log.setLogNode(logWrapper);

        Log.i("TAG", "***** Logging starting... *****");
    }
}
