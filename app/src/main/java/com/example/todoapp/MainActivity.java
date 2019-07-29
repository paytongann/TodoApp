package com.example.todoapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private static final int REQUEST_ADD_TASK = 137;//random.org
    ListView lv_todo_list;
    FloatingActionButton btn_save_task;
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_todo_list = findViewById(R.id.lv_todo_task);
        btn_save_task = findViewById(R.id.fba_add_task);

        adapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1
        );
        lv_todo_list.setAdapter(adapter);

        btn_save_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        getBaseContext(),
                        NewTask.class
                );
                startActivity(intent);
                startActivityForResult(intent, REQUEST_ADD_TASK);
            }
        });

        lv_todo_list.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent,
                                           View view,
                                           int position,
                                           long id) {
                adapter.remove(
                        adapter.getItem(position));
                return false;
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode,
                                    int resultCode,
                                    @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == REQUEST_ADD_TASK){
            if(resultCode == RESULT_OK){
                String category = data.getStringExtra("Category");
                String task = data.getStringExtra("Task");
                adapter.add("Task: "+task+"\nCategory: "+category);
            }
        }
    }
}
