package com.example.meghal.sqliteapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import static android.provider.BlockedNumberContract.BlockedNumbers.COLUMN_ID;


public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;
    public static final String db_name="sample_db";
    public static final String db_tablename="student";
    public static final String col1="id";
    public static final String col2="name";
    public static final String col3="subject";
    public static final String col4="mark";

    public DatabaseHelper(Context context) {
        super(context,db_name, null,1);

        SQLiteDatabase db =this.getWritableDatabase();

        ContentValues values = new ContentValues();
        db.insert(db_tablename, null, values);
        db.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_TABLE="CREATE TABLE " +
                db_tablename + "("
                + col1 + " INTEGER PRIMARY KEY," + col2
                + " TEXT," + col3 + " TEXT," + col4 +"INTEGER"+")";

        db.execSQL(CREATE_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {

        db.execSQL("DROP TABLE IF EXISTS "+db_tablename);

        onCreate(db);


    }

}
