package com.example.testfragment;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testfragment.databinding.BatchItemListBinding;

import java.util.ArrayList;

public class BatchItemListAdapter extends RecyclerView.Adapter<BatchItemListAdapter.BatchViewHolder> {
   Context context;
   ArrayList<Batch>al;
   public BatchItemListAdapter(Context context,ArrayList<Batch>al){
       this.context = context;
       this.al = al;
   }

    @NonNull
    @Override
    public BatchViewHolder onCreateViewHolder(@NonNull  ViewGroup parent, int viewType) {
       BatchItemListBinding binding = BatchItemListBinding.inflate(LayoutInflater.from(context),parent,false);
       return new BatchViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull  BatchItemListAdapter.BatchViewHolder holder, int position) {
        Batch b = al.get(position);
        if(b.getBatchSubject().equalsIgnoreCase("Android"))
            holder.binding.imageView.setImageResource(R.drawable.android);
        else if(b.getBatchSubject().equalsIgnoreCase("Java"))
            holder.binding.imageView.setImageResource(R.drawable.java);
        else if(b.getBatchSubject().equalsIgnoreCase("Javascript"))
            holder.binding.imageView.setImageResource(R.drawable.js);
        else if(b.getBatchSubject().equalsIgnoreCase("Python"))
            holder.binding.imageView.setImageResource(R.drawable.python);
        else if(b.getBatchSubject().equalsIgnoreCase("c programming"))
            holder.binding.imageView.setImageResource(R.drawable.c);
        else if(b.getBatchSubject().equalsIgnoreCase("CPP"))
            holder.binding.imageView.setImageResource(R.drawable.cpp);
        holder.binding.tvBatchTitle.setText(b.getBatchSubject()+"\nFrom "+b.getFromTime()+" to "+b.getToTime());

    }

    @Override
    public int getItemCount() {
        return al.size();
    }

    public class BatchViewHolder extends RecyclerView.ViewHolder{
       BatchItemListBinding binding;
       public BatchViewHolder(BatchItemListBinding binding){
           super(binding.getRoot());
           this.binding = binding;
       }
   }
}
