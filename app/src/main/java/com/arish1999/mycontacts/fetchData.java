package com.arish1999.mycontacts;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.ArrayList;

public class fetchData extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<model> modelArrayList;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fetch_data);
        recyclerView = findViewById(R.id.recyclerView);
        context = getApplicationContext();
        modelArrayList = new ArrayList<>();

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        Cursor cursor = new dbManager(this).readAlldata();

        while (cursor.moveToNext())
        {
            model obj = new model(cursor.getString(1),cursor.getString(2),cursor.getString(3));
            modelArrayList.add(obj);
        }

       MyAdapter myAdapter = new MyAdapter(modelArrayList,getApplicationContext());
        recyclerView.setAdapter(myAdapter);






    }
}