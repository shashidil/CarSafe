package com.example.helloworld.Refuel;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;
import com.example.helloworld.Repair.Repair_View;

import java.util.Calendar;
import java.util.List;

public class refueling extends AppCompatActivity {
    EditText edtDate,edtCost,edtLocation,edtqty;
    Button btnSAve,btnHistory;
    DBhelp db;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_refueling);

        edtDate=findViewById(R.id.edtRefuelDate);
        edtCost=findViewById(R.id.edtRefuelcost);
        edtLocation=findViewById(R.id.edtRefuellocation);
        edtqty=findViewById(R.id.edtRefuelqty);
        spinner= findViewById(R.id.spvehuRfnum);

        btnSAve = findViewById(R.id.btnRefuelAdd);
        btnHistory = findViewById(R.id.btnRefuelView);
        db =new DBhelp(this);


        Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);

        edtDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(refueling.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date =day+"/"+month+"/"+year;
                        edtDate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        loadData();
        btnSAve.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String refelDate = edtDate.getText().toString();
                int Cost = Integer.parseInt(edtCost.getText().toString());
                String location  = edtLocation.getText().toString();
                int qty = Integer.parseInt(edtqty.getText().toString());



                Boolean checkinsert = db.insertRefule(refelDate,Cost,location,qty);

                if (checkinsert==true)
                    Toast.makeText(refueling.this,"Succussfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(refueling.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });
        btnHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(),RefuelView.class));
            }
        });

    }

    public  void loadData(){

        List<String> vehiNUm = db.getVehiNum();
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, vehiNUm);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        //passed new instance for

    }
}