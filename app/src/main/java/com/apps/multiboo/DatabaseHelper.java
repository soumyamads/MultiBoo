package com.apps.multiboo;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by soumya on 1/4/2016.
 */
public class DatabaseHelper extends SQLiteOpenHelper
{

    public static final String DATABASE_NAME = "highscores";

    public DatabaseHelper(Context context)
    {
        super(context, DATABASE_NAME, null, 1);
    }                       // I don't even need this, do I? ...

    @Override
    public void onCreate(SQLiteDatabase db)
    {

        String sql = "CREATE TABLE IF NOT EXISTS scoretable (" +
                "_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                "Date STRING, " +
                "Score INTEGER);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion)
    {
        //Not used
        db.execSQL("DROP TABLE IF EXISTS scoretable");

        // create fresh books table
        this.onCreate(db);
    }
}