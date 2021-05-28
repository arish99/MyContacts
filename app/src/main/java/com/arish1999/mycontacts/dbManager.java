package com.arish1999.mycontacts;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class dbManager extends SQLiteOpenHelper {

    private static final String dbName = "dbContact";
    public dbManager(@Nullable Context context) {
        super(context, dbName, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "create table tbl_contact ( id integer primary key autoincrement, name text, contact text, email text)";
        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String query = "DROP TABLE IF EXISTS tbl_contact";
        db.execSQL(query);
        onCreate(db);

    }

    public String addRecord(String name,String contact,String email)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("name",name);
        cv.put("contact",contact);
        cv.put("email",email);
        float res =  db.insert("tbl_contact",null,cv);
        if(res==-1)
            return "Failed";
        else
            return "Successfully Added";

    }
    public Cursor readAlldata()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String query = "select * from tbl_contact order by id desc";
        Cursor cursor = db.rawQuery(query,null);
        return cursor;


    }


}
