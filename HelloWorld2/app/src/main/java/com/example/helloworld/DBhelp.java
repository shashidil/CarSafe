package com.example.helloworld;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class DBhelp extends SQLiteOpenHelper {
    public DBhelp(Context context) {
        super(context, "vehical.db", null, 4);

    }

    @Override
    public void onCreate(SQLiteDatabase DB) {
        DB.execSQL("create table vehical_details(name text NOT NULL,vehiNum text primary key NOT NULL ,manufacture text NOT NULL,model text NOT NULL,fuel text NOT NULL)");
        DB.execSQL("create table repair_details(repair_id interger primary key  NOT NULL" +
                ",repair_type text NOT NULL,descrption text NOT NULL,cost text NOT NULL,date Date NOT NULL)");
        DB.execSQL("create table service_details(center_name text NOT NULL,milaege int primary key NOT NULL,oil_state text NOT NULL,descrption text NOT NULL,Date date NOT NULL)");
        DB.execSQL("create table refueling_details (refuel_id interger primary key,Date date  NOT NULL ,cost Interger  NOT NULL ,location text NOT NULL ,qty interger  NOT NULL)");

    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("drop table if exists vehical_details");
        DB.execSQL("drop table if exists repair_details");
        DB.execSQL("drop table if exists service_details");
        DB.execSQL("drop table if exists refueling_details");

        onCreate(DB);

    }

    // insert data to vehicle table
    public boolean insertData( String name, String vehiNum, String maufacture, String model,String fuel) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("vehiNum", vehiNum);
        contentValues.put("manufacture", maufacture);
        contentValues.put("model", model);
        contentValues.put("fuel", fuel);
        long result = DB.insert("vehical_details", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    //view data from vehicle table
    public Cursor getdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from vehical_details order by vehiNum desc", null);
        return cursor;
    }

    /*public Cursor genaratePk(){
        int record =0;
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select count (repair_type) from repair_details",null);
        return cursor;
    }*/

    // Insert dato to repair+details table
    public boolean insertRepair(String repair_id ,String rapair_type, String descrption, String cost, String date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("repair_id", repair_id);
        contentValues.put("repair_type", rapair_type);
        contentValues.put("descrption", descrption);
        contentValues.put("cost", cost);
        contentValues.put("date", date);

        long result = DB.insert("repair_details", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }


    }

    //view data from repair table
    public Cursor getrepairdata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from repair_details", null);
        return cursor;
    }

    // inser data in to service_details table
    public boolean insertService(String center_name, int milaege, String oil_state, String descrption, String date) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("center_name", center_name);
        contentValues.put("milaege", String.valueOf(milaege));
        contentValues.put("oil_state", oil_state);
        contentValues.put("descrption", descrption);
        contentValues.put("Date", date);

        long result = DB.insert("service_details", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    //view data from service_details
    public Cursor getservicedata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from service_details", null);
        return cursor;
    }

    //view data from Vehical Number
    public List<String> getVehiNum() {
        List<String> vehiNUm = new ArrayList<String>();
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select vehiNum from vehical_details", null);

        if(cursor.moveToFirst()){
            do {
                vehiNUm.add(cursor.getString(0));
            } while (cursor.moveToNext());
        }
        return vehiNUm;
    }

    public boolean insertRefule(String Date  ,int cost ,String location  , int qty) {
        SQLiteDatabase DB = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("Date", Date);
        contentValues.put("cost", String.valueOf(cost));
        contentValues.put("location", location);
        contentValues.put("qty", qty);

        long result = DB.insert("refueling_details", null, contentValues);

        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Cursor getrefueldata() {
        SQLiteDatabase DB = this.getWritableDatabase();
        Cursor cursor = DB.rawQuery("select * from refueling_details", null);
        return cursor;
    }

}
