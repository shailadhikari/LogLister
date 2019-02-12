package com.example.android.myrecyclerview.view;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.android.myrecyclerview.logging.Log;
import com.example.android.myrecyclerview.logging.LogNode;

@SuppressLint("AppCompatCustomView")
public class LogView extends TextView implements LogNode {

    //For piping : The next node to receive Log data after this one has done its work.
    private LogNode mNext;


    public LogNode getNext() {
        return mNext;
    }

    public void setNext(LogNode mNext) {
        this.mNext = mNext;
    }

    public LogView(Context ctx){
        super(ctx);
    }

    public LogView(Context ctx, AttributeSet attrs){
        super(ctx, attrs);
    }

    public LogView(Context ctx, AttributeSet attrs, int defStyle){
        super(ctx, attrs, defStyle);
    }


    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        String priorityStr = null;

        //printing priority as readable text
        switch(priority){

            case Log.VERBOSE:
                priorityStr = "VERBOSE";
                break;

            case Log.INFO:
                priorityStr = "INFO";
                break;

            case Log.DEBUG:
                priorityStr = "DEBUG";
                break;

            case Log.ASSERT:
                priorityStr = "ASSERT";
                break;

            case Log.WARNING:
                priorityStr = "WARNING";
                break;

            case Log.ERROR:
                priorityStr = "ERROR";
                break;

            default:
                break;
        }

        String exceptionStr = null;

        if(tr != null)
            exceptionStr = android.util.Log.getStackTraceString(tr);


        // append all the stuff to one string builder object
        final StringBuilder strBuilder = new StringBuilder();

        String delimiter = "\t";
        appendIfNotNull(strBuilder, priorityStr, delimiter);
        appendIfNotNull(strBuilder, tag, delimiter);
        appendIfNotNull(strBuilder, msg, delimiter);
        appendIfNotNull(strBuilder, exceptionStr, delimiter);

        //In case this is called from an AsyncTask, making sure the updates happen in the UI thread.
        ((Activity)getContext()).runOnUiThread(new Thread(new Runnable() {
            @Override
            public void run() {
                //Display the text we just generated within the LogView
                appendToLog(strBuilder.toString());
            }
        }));

        if(mNext != null)
            mNext.println(priority, tag, msg, tr);
    }

    private StringBuilder appendIfNotNull(StringBuilder strBuilder, String addStr, String delimiter){
        if(addStr != null){
            if(addStr.length() == 0)
                delimiter = "";

            return strBuilder.append(addStr).append(delimiter);
        }
        return strBuilder;
    }

    private void appendToLog(String s){
        append("\n"  + s);
    }




}
