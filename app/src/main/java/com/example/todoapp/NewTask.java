package com.example.todoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class NewTask extends AppCompatActivity {

    TextInputLayout taskLayout;
    TextInputLayout categoryLayout;
    Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_task);
        taskLayout = findViewById(R.id.til_add_task);
        categoryLayout = findViewById(R.id.til_add_category);
        addButton = findViewById(R.id.btn_add_task);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String task = taskLayout.getEditText().getText().toString();
                String category = categoryLayout.getEditText().getText().toString();
                Intent intent = new Intent();
                intent.putExtra("Task", task);
                intent.putExtra("Category", category);
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}