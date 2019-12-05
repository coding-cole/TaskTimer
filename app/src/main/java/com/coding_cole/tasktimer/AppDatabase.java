package com.coding_cole.tasktimer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

/**
 * basic database class for the app
 *
 * the only class that should use this is the {@link AppProvider}.
 */

class AppDatabase extends SQLiteOpenHelper {
    private static final String TAG = "AppDatabase";

    public static final String DATABASE_NAME = "TaskTmer.db";
    public static final int DATABASE_VERSION = 1;


    // implement appDatabase as a Singleton
    public static AppDatabase instance = null;

    private AppDatabase(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        Log.d(TAG, "AppDatabase: constructor");
    }

    /**
     *
     * Get an instance of the apps singleton database helper object
     * @param context the content providers context
     * @return a sqlite database object
     */

    static AppDatabase getInstance(Context context) {
        if (instance == null) {
            Log.d(TAG, "getInstance: creating new instance");
        }
        return instance;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate: starts");
        String sSQL; // use a string variable to  facilitate logging
//        sSQL = "CREATE TABLE Tasks (_id INTEGER PRIMARY KEY NOT NULL, Name TEXT NOT NULL, Description TEXT, SortOrder INTEGER);";
        sSQL = "CREATE TABLE " + TasksContract.TABLE_NAME + " ("
            +TasksContract.Coloumns._ID + " INTEGER PRIMARY KEY NOT NULL, "
            +TasksContract.Coloumns.TASKS_NAME + " TEXT NOT NULL, "
            +TasksContract.Coloumns.TASKS_DESCRIPTION + " TEXT, "
            +TasksContract.Coloumns.TASKS_SORTORDER + " INTEGER);";
        Log.d(TAG,  sSQL);
        db.execSQL(sSQL);

        Log.d(TAG, "onCreate: ends");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "onUpgrade: starts");
        switch (oldVersion) {
            case 1:
               // upgarde logic from v1
                break;
            default:
                throw new IllegalStateException("onUpgrade() with unknown new version: " + newVersion);
        }
        Log.d(TAG, "onUpgrade: ends");
    }
}
