package com.example.helloworld.Vehical;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;

import java.util.ArrayList;


public class VehucalDetails extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<model> dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehucal_details);

        dataholder = new ArrayList<model>();

        recyclerView= findViewById(R.id.recyview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        Cursor cursor = new DBhelp(this).getdata();

        while (cursor.moveToNext()){

            model obj = new model(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            dataholder.add(obj);
        }
        myAdpter adpter = new myAdpter(dataholder);
        recyclerView.setAdapter(adpter);
    }
}