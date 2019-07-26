package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView lv_todo_list;
    EditText et_task;
    Button btn_save_task;
    ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lv_todo_list = findViewById(R.id.lv_todo_task);
        et_task = findViewById(R.id.et_task);
        btn_save_task = findViewById(R.id.btn_add_task);

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1);
        lv_todo_list.setAdapter(adapter);

        //Saves item to the list and clears txt field.
        btn_save_task.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String task = et_task.getText().toString();
                if (task.isEmpty()) return;

                adapter.add(task);
                et_task.setText("");
            }
        });
        //Deleting item from list by long clicking it.
        lv_todo_list.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapterView, View view, int position, long id) {
                        adapter.remove(
                        adapter.getItem(position));
                        return false;
                    }
                }
        );
    }
}