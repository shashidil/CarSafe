package com.example.helloworld.Repair;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
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

import java.util.Calendar;
import java.util.List;

public class repairs extends AppCompatActivity {
    EditText etDAte,repair,discription,cost;
    Button add,view;
    DBhelp db;
    Spinner spVehiNum;
    ArrayAdapter<String> adapter;
    String repair_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repairs);

        etDAte= findViewById(R.id.edtdate);
        repair= findViewById(R.id.edtRepairtype);
        discription= findViewById(R.id.edtRepairDes);
        cost= findViewById(R.id.edtRepaircost);
        spVehiNum= findViewById(R.id.spVehiNum);

        add= findViewById(R.id.btnRepairAdd);
        view= findViewById(R.id.btnrepairView);

        db= new DBhelp(this);



        Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        etDAte.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(repairs.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date =day+"/"+month+"/"+year;
                        etDAte.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        loadData();




        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String idtxt = spVehiNum.getSelectedItem().toString();
                String repairtxt = repair.getText().toString();
                String destxt = discription.getText().toString();
                String costtxt = cost.getText().toString();
                String datetxt = etDAte.getText().toString();


                Boolean checkinsert = db.insertRepair(idtxt,repairtxt,destxt,costtxt,datetxt);

                if (checkinsert==true)
                    Toast.makeText(repairs.this,"Succussfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(repairs.this,"Failed",Toast.LENGTH_SHORT).show();
            }

        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), Repair_View.class));
            }

//                Cursor re =db.getrepairdata();
//                if (re.getCount()==0)
//                    Toast.makeText(repairs.this,"No Record",Toast.LENGTH_SHORT).show();
//                StringBuffer buffer= new StringBuffer();
//                 //Cursor record = db.genaratePk();
//
//                while(re.moveToNext()){
//                    //buffer.append("Repair ID :"+record.getString(0)+"\n");
//                    buffer.append("Repair Type :"+re.getString(1)+"\n");
//                    buffer.append("Description :"+re.getString(2)+"\n");
//                    buffer.append("Cost :"+re.getString(3)+"\n");
//                    buffer.append(" Date :"+re.getString(4)+"\n\n");
//                }
//                AlertDialog.Builder builder= new AlertDialog.Builder(repairs.this);
//                builder.setCancelable(true);
//                builder.setTitle("Repair Details");
//                builder.setMessage(buffer.toString());
//                builder.show();
//            }


        });

    }

    public  void loadData(){

        List<String> vehiNUm = db.getVehiNum();
        // Create an ArrayAdapter using the string array and a default spinner layout
        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,vehiNUm);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spVehiNum.setAdapter(adapter);
        //passed new instance for
        
    }
}