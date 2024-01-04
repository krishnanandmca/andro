package com.example.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class SpinnerExample extends AppCompatActivity {

    String[] course = {"MCA","MBA","MTECH"};

    Spinner s;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner_example);
        s = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter =new  ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,course);
//        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String item = course[position];
                if("MCA".equals(item)){
                    String msg = "MCA";
                    new AlertDialog.Builder(SpinnerExample.this)
                            .setTitle("caption")
                            .setMessage(msg)
                            .setPositiveButton("ok",(which,dialog)->{})
                            .show();

                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}