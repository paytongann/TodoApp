package com.example.todoapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ToDoDatabase extends SQLiteOpenHelper {

    public ToDoDatabase(Context context) {
        super(context,
                DatabaseUtil.databaseName,
                null,
                DatabaseUtil.dabtabaseVersion);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "CREATE TABLE "+
                        DatabaseUtil.TaskTable.tableName +
                        " (" +
                        DatabaseUtil.TaskTable._ID +
                        " INTEGER PRIMARY KEY," +
                        DatabaseUtil.TaskTable.taskColumn +
                        " VARCHAR(255)," +
                        DatabaseUtil.TaskTable.categoryColumn +
                        " VARCHAR(255))"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
