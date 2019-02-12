package com.example.android.myrecyclerview.logging;

public class Log {

    public static final int NONE = -1;
    public static final int VERBOSE = android.util.Log.VERBOSE;
    public static final int DEBUG = android.util.Log.DEBUG;
    public static final int INFO = android.util.Log.INFO;
    public static final int WARNING = android.util.Log.WARN;
    public static final int ERROR = android.util.Log.ERROR;
    public static final int ASSERT = android.util.Log.ASSERT;

    //stores the beginning of the LogNode topology
    private static LogNode mLogNode;

    public static LogNode getLogNode(){
        return mLogNode;
    }

    public static void setLogNode(LogNode node){
        mLogNode = node;
    }


    //STARTING THE PRINTING FROM THE FIRST NODE
    public static void println(int priority, String tag, String msg, Throwable tr){
        if(mLogNode !=null)
            mLogNode.println(priority, tag, msg, tr);
    }

    public static void println(int priority, String tag, String msg){
        println(priority, tag, msg, null);
    }

    //VERBOSE
    public static void v(String tag, String msg){
        v(tag, msg, null);
    }

    public static void v(String tag, String msg, Throwable tr){
        println(VERBOSE, tag, msg, tr);
    }

    //INFO
    public static void i(String tag, String msg){
        i(tag, msg, null);
    }

    public static void i(String tag, String msg, Throwable tr){
        println(INFO, tag, msg, tr);
    }

    //WARNING
    public static void w(String tag, String msg){
        w(tag, msg, null);
    }

    public static void w(String tag, String msg, Throwable tr){
        println(WARNING, tag, msg, tr);
    }

    //DEBUG
    public static void d(String tag, String msg){
        d(tag, msg, null);
    }

    public static void d(String tag, String msg, Throwable tr){
        println(DEBUG, tag, msg, tr);
    }


    //ASSERT
    public static void a(String tag, String msg){
        a(tag, msg, null);
    }

    public static void a(String tag, String msg, Throwable tr){
        println(ASSERT, tag, msg, tr);
    }

    //ERROR
    public static void e(String tag, String msg){
        e(tag, msg, null);
    }

    public static void e(String tag, String msg, Throwable tr){
        println(ERROR, tag, msg, tr);
    }

}
