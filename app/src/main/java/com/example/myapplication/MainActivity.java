package com.example.myapplication;


import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    EditText et1, etName2, etCourse2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showRecords();
    }

    public void btn_add_record(View view){
        EditText et1 = (EditText) findViewById(R.id.etId);
        EditText etName2 = (EditText)findViewById(R.id.etName);
        EditText etCourse2 = (EditText)findViewById(R.id.etCategory);

        String id = et1.getText().toString();
        String name = etName2.getText().toString();
        String course = etCourse2.getText().toString();

        DatabaseManager db = new DatabaseManager(this);
        db.addRecord(id, name, course);
        showRecords();
        Toast.makeText(this," record added successfully...", Toast.LENGTH_LONG).show();

    }

    private void showRecords(){
        DatabaseManager db = new DatabaseManager(this);
        ArrayList<Student> list = db.showRecord();

        CustomAdapter adapter = new CustomAdapter(this, list);

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);

        db.close();
    }
}
