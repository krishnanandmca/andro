package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Pgm12 extends AppCompatActivity {
    ListView lv;
    String[] courses = {"MCA","MBA","MTECH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm12);

        lv = findViewById(R.id.lv);

        ArrayAdapter<String> adapter = new  ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,courses);

        lv.setAdapter(adapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(Pgm12.this, String.valueOf(courses[position]), Toast.LENGTH_SHORT).show();
            }
        });

    }
}