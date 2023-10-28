package com.example.helloworld.Service;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.helloworld.DBhelp;
import com.example.helloworld.R;
import com.example.helloworld.Repair.Repair_View;

import java.util.Calendar;
import java.util.List;

public class Service extends AppCompatActivity {
EditText centerName;
    EditText Mileage;
    Spinner spinner;
    EditText edtdate;
    EditText discription;
    ArrayAdapter<String> adapter;
Button btnServiceadd,btnServiceview;
DatePickerDialog.OnDateSetListener setListener;
DBhelp db;
String oilValue;

RadioButton rbYes;
RadioButton rbNo;
RadioGroup rbgroup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_service);

        centerName= findViewById(R.id.edtServicecenter);
        Mileage= findViewById(R.id.edtServiceMileage);
        edtdate =findViewById(R.id.edtServicedate);
        discription= findViewById(R.id.edtServiceDes);

        btnServiceadd= findViewById(R.id.btnServiceAdd);
        btnServiceview= findViewById(R.id.btnServiceView);

        rbYes=findViewById(R.id.rbYes);
        rbNo=findViewById(R.id.rbNo);
        spinner= findViewById(R.id.spvehuSnum);



        db= new DBhelp(this);


        Calendar calendar= Calendar.getInstance();
        final int year = calendar.get(Calendar.YEAR);
        final int month = calendar.get(Calendar.MONTH);
        final int day = calendar.get(Calendar.DAY_OF_MONTH);


        edtdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(Service.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        month=month+1;
                        String date =day+"/"+month+"/"+year;
                        edtdate.setText(date);

                    }
                },year,month,day);
                datePickerDialog.show();
            }
        });

        loadData();
               rbYes.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                   @Override
                   public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                       rbYes= findViewById(R.id.rbYes);
                       oilValue="Yes";
                   }
               });

        rbNo.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                rbYes= findViewById(R.id.rbYes);
                oilValue="No";

                 }
        });



        btnServiceadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String Servicecentertxt = centerName.getText().toString();
                String  mileagetxt = Mileage.getText().toString();
                String distxt = discription.getText().toString();
                String datetxt = edtdate.getText().toString();
                String rbvaluetxt= oilValue;


                Boolean checkinsert = db.insertService(Servicecentertxt,Integer.parseInt(mileagetxt),rbvaluetxt,distxt,datetxt);

                if (checkinsert==true)
                    Toast.makeText(Service.this,"Succussfully",Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(Service.this,"Failed",Toast.LENGTH_SHORT).show();
            }
        });


        btnServiceview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(getApplicationContext(), ServiceView .class));
            }
//                Cursor re =db.getservicedata();
//                if (re.getCount()==0)
//                    Toast.makeText(Service.this,"No Record",Toast.LENGTH_SHORT).show();
//                StringBuffer buffer= new StringBuffer();
//
//
//                while(re.moveToNext()){
//
//                    buffer.append("Service Center :"+re.getString(0)+"\n");
//                    buffer.append("Mileage :"+re.getString(1)+"\n");
//                    buffer.append("Change Oil :"+re.getString(2)+"\n");
//                    buffer.append(" Description :"+re.getString(4)+"\n");
//                    buffer.append(" Date :"+re.getString(5)+"\n");
//                }
//                AlertDialog.Builder builder= new AlertDialog.Builder(Service.this);
//                builder.setCancelable(true);
//                builder.setTitle("service_details");
//                builder.setMessage(buffer.toString());
//                builder.show();
//
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
        spinner.setAdapter(adapter);
        //passed new instance for

    }
//    public void onRadioButtonClicked(View view){
//
//        boolean checked = ((RadioButton) view).isChecked();
//
//        switch(view.getId()) {
//            case R.id.rbYes:
//                if (checked)
//                    oilValue = "yes";
//                    break;
//            case R.id.rbNo:
//                if (checked)
//                    oilValue = "No";
//                    break;
//        }
//
//
//
//    }


}