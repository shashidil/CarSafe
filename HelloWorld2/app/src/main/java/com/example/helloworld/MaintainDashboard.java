package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.Repair.repairs;
import com.example.helloworld.Service.Service;

public class MaintainDashboard extends AppCompatActivity {

    Button repair,service,refueling;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maintain_dashboard);

        repair = findViewById(R.id.btnRepair);
        service= findViewById(R.id.btnservice);
        refueling= findViewById(R.id.btnMileage);

        repair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MaintainDashboard.this, repairs.class);
                startActivity(intend);

            }
        });

        service.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MaintainDashboard.this, Service.class);
                startActivity(intend);
            }
        });

        refueling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MaintainDashboard.this, com.example.helloworld.Refuel.refueling.class);
                startActivity(intend);
            }
        });

    }
}