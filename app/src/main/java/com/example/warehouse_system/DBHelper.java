package com.example.warehouse_system;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "warehouse.db";
    final static int DATABASE_VERSION = 1;
    final static String TABLE_NAME="warehouse_table";
    final static String COLUMN_ID = "_id";
    final static String COLUMN_NAME="Name";
    final static String COLUMN_DESCRIBE="Deccribe";
    final static String COLUMN_LINK_PICTURE="Link_picture";
    final static String COLUMN_PRICE="Price";
    final static String COLUMN_AMOUNT="Amount";
    final static String COLUMN_PRODUCER="Producer";

    final static int NUM_COLUMN_ID=0;
    final static int NUM_COLUMN_NAME=1;
    final static int NUM_COLUMN_DESCRIBE=2;
    final static int NUM_COLUMN_LINK_PICTURE=3;
    final static int NUM_COLUMN_PRICE=4;
    final static int NUM_COLUMN_AMOUNT=5;
    final static int NUM_COLUMN_PRODUCER=6;


    public DBHelper(@Nullable Context context) {
        super(context, "Warehouse", null, 1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String query = "CREATE TABLE " + TABLE_NAME + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY NOT NULL UNIQUE, " +
                COLUMN_NAME+ " TEXT, " +
                COLUMN_DESCRIBE + " TEXT, " +
                COLUMN_LINK_PICTURE + " TEXT,"+
                COLUMN_PRICE+" TEXT,"+
                COLUMN_AMOUNT+" TEXT,"+
                COLUMN_PRODUCER+" TEXT);";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
