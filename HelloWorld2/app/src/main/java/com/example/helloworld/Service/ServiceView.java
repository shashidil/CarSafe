package com.example.helloworld.Service;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.database.Cursor;
import android.os.Bundle;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;


import java.util.ArrayList;

public class ServiceView extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<ServiceModel> service_dataholder;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service_view);


        service_dataholder = new ArrayList<ServiceModel>();
        recyclerView= findViewById(R.id.recyService);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        Cursor cursor = new DBhelp(this).getservicedata();

        while (cursor.moveToNext()){

            ServiceModel data = new ServiceModel(cursor.getString(0),cursor.getString(1),cursor.getString(2),cursor.getString(3),cursor.getString(4));
            service_dataholder.add(data);
        }
        ServiceAdpter adpter = new ServiceAdpter(service_dataholder);
        recyclerView.setAdapter(adpter);

    }
}