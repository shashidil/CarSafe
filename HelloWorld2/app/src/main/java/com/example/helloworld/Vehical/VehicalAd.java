package com.example.helloworld.Vehical;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;

public class VehicalAd extends AppCompatActivity {
    EditText name,vehiNum,manufacture,model,fuel_type;

    Button add,view;
    DBhelp DB;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_vehical);



        name = findViewById(R.id.edtVehicalName);
        vehiNum= findViewById(R.id.edtVehicalnum);
        manufacture= findViewById(R.id.edtManufacture);
        model= findViewById(R.id.edtModel);
        fuel_type= findViewById(R.id.edtFuel);

        add= findViewById(R.id.btnAdd);
        view= findViewById(R.id.btnView);



        DB= new DBhelp(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nametxt = name.getText().toString();
                String vehiNumtxt = vehiNum.getText().toString();
                String manufacturetxt = manufacture.getText().toString();
                String modeltxt = model.getText().toString();
                String fueltxt = fuel_type.getText().toString();

                Boolean checkinsert = DB.insertData(nametxt,vehiNumtxt,manufacturetxt,modeltxt,fueltxt);

                if (checkinsert==true)
                    Toast.makeText(VehicalAd.this,"Succussfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(VehicalAd.this,"Failed",Toast.LENGTH_SHORT).show();



            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Intent intend = new Intent(VehicalAd.this,VehucalDetails.class);
                //startActivity(intend);
               startActivity(new Intent(getApplicationContext(), VehucalDetails.class));

            }

        });







        }




    }


