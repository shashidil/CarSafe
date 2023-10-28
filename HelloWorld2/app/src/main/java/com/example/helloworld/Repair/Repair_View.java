package com.example.helloworld.Repair;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;
import com.example.helloworld.Vehical.model;
import com.example.helloworld.Vehical.myAdpter;

import java.util.ArrayList;

public class Repair_View extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RepairModel> repair_dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_view);

        repair_dataholder = new ArrayList<RepairModel>();
        recyclerView= findViewById(R.id.recyRepaireView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Cursor cursor = new DBhelp(this).getrepairdata();

        while (cursor.moveToNext()){

            RepairModel data = new RepairModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            repair_dataholder.add(data);
        }
        repairAdpter adpter = new repairAdpter(repair_dataholder);
        recyclerView.setAdapter(adpter);

    }
}