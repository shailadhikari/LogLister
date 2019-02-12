package com.example.android.myrecyclerview.logging;

public interface LogNode {

    /**
     * Instructs the first LogNode in the list to print the log data provided.
     * @param priority Log level of the data
     * @param tag Tag for the logged data. Can be used to organize the log statements.
     * @param tr If an error was thrown, this can be used to make the log more informative
     */
    public void println(int priority, String tag, String msg, Throwable tr);

}
