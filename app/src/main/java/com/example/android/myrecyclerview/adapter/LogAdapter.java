package com.example.android.myrecyclerview.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.myrecyclerview.R;
import com.example.android.myrecyclerview.logging.Log;

public class LogAdapter extends RecyclerView.Adapter<LogAdapter.ViewHolder> {

    private static final String TAG = "LogAdapter";

    private String[] dataset;

    //Provide a reference to the type of views that you are using
    public static class ViewHolder extends RecyclerView.ViewHolder{
        private final TextView tv;

        public ViewHolder(View v){
            super(v);

            v.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {
                    Log.d(TAG, "Element "+getAdapterPosition()+" clicked.");
                }
            });

            tv = (TextView) v.findViewById(R.id.textView);
        }

        public TextView getTextView(){
            return tv;
        }
    }

    //Init the dataset of the adapter
    public LogAdapter(String[] mDataset){
        this.dataset = mDataset;
    }

    //create new vies, invoked by layout manager
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType){
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.text_row_item, viewGroup, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int pos) {
        viewHolder.getTextView().setText(dataset[pos]);
    }

    @Override
    public int getItemCount() {
        return dataset.length;
    }


}
