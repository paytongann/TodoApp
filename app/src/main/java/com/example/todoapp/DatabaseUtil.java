package com.example.todoapp;

import android.provider.BaseColumns;

public class DatabaseUtil {
    public static final String databaseName = "tododb";
    public static final int dabtabaseVersion = 1;

    public class TaskTable implements BaseColumns {
        public static final String tableName = "task";
        public static final String taskColumn = "name";
        public static final String categoryColumn = "category";
    }
}
