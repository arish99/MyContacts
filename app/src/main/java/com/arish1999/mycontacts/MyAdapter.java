package com.arish1999.mycontacts;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

class MyAdapter extends RecyclerView.Adapter<MyAdapter.myviewHolder> {
    ArrayList<model> modelArrayList;
    Context context;




    public MyAdapter(ArrayList<model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;


    }


    @NonNull
    @Override
    public myviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_data,parent,false);
        return new myviewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull myviewHolder holder, int position) {
        holder.dname.setText(modelArrayList.get(position).getName());
        holder.dcontact.setText(modelArrayList.get(position).getContact());
        holder.demail.setText(modelArrayList.get(position).getEmail());


    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }

    class myviewHolder extends RecyclerView.ViewHolder{
        TextView dname,dcontact,demail;
        Button delete;

        public myviewHolder(@NonNull View itemView) {
            super(itemView);
            dname = itemView.findViewById(R.id.displayname);
            dcontact = itemView.findViewById(R.id.displaycontact);
            demail = itemView.findViewById(R.id.displayemail);

        }
    }


}



