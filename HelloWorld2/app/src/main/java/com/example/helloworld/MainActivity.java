package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.helloworld.Vehical.VehicalAd;

public class MainActivity extends AppCompatActivity {
    Button btnOWN,btnMainn,btntips;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        btnOWN=findViewById(R.id.btnowner);
        btnMainn=findViewById(R.id.btnmanage);
        btntips= findViewById(R.id.btnskill);

        btnOWN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MainActivity.this, VehicalAd.class);
                startActivity(intend);

            }
        });
        btnMainn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MainActivity.this,MaintainDashboard.class);
                startActivity(intend);
            }
        });
        btntips.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intend = new Intent(MainActivity.this,DriveTips.class);
                startActivity(intend);
            }
        });


    }
}