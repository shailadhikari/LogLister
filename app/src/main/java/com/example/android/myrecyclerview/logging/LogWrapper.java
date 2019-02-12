package com.example.android.myrecyclerview.logging;

import android.util.Log;

/**
 * Helper class which wraps Android's native logging utilities in the Logger Interface
 * This was the main DDMS output can be one of the main targets receiving and outputting the logs simultaneously.
 */

public class LogWrapper implements LogNode{




    //For piping : The next node to receive Log data after this one has done its work.
    private LogNode mNext;


    public LogNode getNext() {
        return mNext;
    }

    public void setNext(LogNode mNext) {
        this.mNext = mNext;
    }


    @Override
    public void println(int priority, String tag, String msg, Throwable tr) {
        String useMsg = msg;

        if(useMsg == null)
            useMsg = "";


        if(tr != null)
            msg += "\n" + Log.getStackTraceString(tr);

        Log.println(priority, tag, useMsg);

        if(mNext != null)
            mNext.println(priority, tag, msg, tr);

    }
}
