package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class DriveTips extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        CheckBox cb1,cb2,cb3,cb4,cb5,cb6,cb7,cb8;
        Button btndone;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drive_tips);

        cb1= findViewById(R.id.cb1);
        cb2= findViewById(R.id.cb2);
        cb3= findViewById(R.id.cb3);
        cb4= findViewById(R.id.cb4);
        cb5= findViewById(R.id.cb5);
        cb6= findViewById(R.id.cb6);
        cb7= findViewById(R.id.cb7);
        cb8= findViewById(R.id.cb8);

        btndone= findViewById(R.id.btnDrive);

        btndone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int count = 0;

                if (cb1.isChecked()) {
                    ++count;
                }

                if (cb2.isChecked()) {
                    ++count;
                }

                if (cb3.isChecked()) {
                    ++count;
                }
                if (cb4.isChecked()) {
                    ++count;
                }
                if (cb5.isChecked()) {
                    ++count;
                }
                if (cb6.isChecked()) {
                    ++count;
                }
                if (cb7.isChecked()) {
                    ++count;
                }
                if (cb8.isChecked()) {
                    ++count;
                }

                if (count >= 8) {

                    AlertDialog.Builder bulder = new AlertDialog.Builder(DriveTips.this);
                    bulder.setTitle("YOUR SAFE");
                    bulder.setMessage("You Reach Safe Zone!!! You Can Drive!!!");
                    bulder.setPositiveButton("OK", null);
                    bulder.show();
                }
                 else {
                    AlertDialog.Builder bulder = new AlertDialog.Builder(DriveTips.this);
                    bulder.setTitle("STOP!!! DON'T DRIVE");
                    bulder.setMessage(Html.fromHtml(" <font color='#FF0000'>Your Not Safe!! Again Read Guidlines</font>"));
                    bulder.setNegativeButton("Cancle", null);
                    bulder.show();
                }


            }
        });
    }
}