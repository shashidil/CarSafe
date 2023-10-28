package com.example.helloworld.Refuel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;
import com.example.helloworld.Service.ServiceModel;

import java.util.ArrayList;

public class RefuelView extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<RefuleModel> refuel_dataholder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refuel_view);

        refuel_dataholder = new ArrayList<RefuleModel>();
        recyclerView = findViewById(R.id.recyRefuel);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Cursor cursor = new DBhelp(this).getrefueldata();

        while (cursor.moveToNext()){

            RefuleModel data = new RefuleModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3));
            refuel_dataholder.add(data);
        }
        RefuelAdpter adpter= new RefuelAdpter(refuel_dataholder);
        recyclerView.setAdapter(adpter);
    }
}