package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NewTask extends AppCompatActivity {

    TextInputLayout taskLayout;
    TextInputLayout categoryLayout;
    Button addButton;
    Button homeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        taskLayout = findViewById(R.id.til_add_task);
        categoryLayout = findViewById(R.id.til_add_category);
        addButton = findViewById(R.id.btn_add_task);
        homeButton = findViewById(R.id.btn_home_task);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskLayout.getEditText().getText().toString();
                String category = categoryLayout.getEditText().getText().toString();
                //Intent intent = new Intent();
                //intent.putExtra("Task", task);
                //intent.putExtra("Category", category);
                //setResult(RESULT_OK, intent);
                //finish();
                saveEntry(task,category);
            }
        });

        homeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(
                        getBaseContext(),
                        RecyclerViewActivity.class
                );
                startActivity(intent);
            }
        });
    }

    public void saveEntry(String task, String category){
        ToDoDatabase database = new ToDoDatabase(this);
        SQLiteDatabase saveData = database.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(DatabaseUtil.TaskTable.taskColumn, task);
        values.put(DatabaseUtil.TaskTable.categoryColumn, category);

        if (saveData.insert(DatabaseUtil.TaskTable.tableName,
                null,
                values) > 0){
            Toast.makeText(this,"Saved values",
                    Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this,"Nothing saved",
                    Toast.LENGTH_SHORT).show();
    }
}