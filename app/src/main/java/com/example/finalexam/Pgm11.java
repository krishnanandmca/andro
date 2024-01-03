package com.example.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

public class Pgm11 extends AppCompatActivity {

    EditText e1, e2, e3, e4;
    Spinner s;

    float fee = 0;

    String[] courses = {"MCA", "MBA", "MTECH"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm11);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        e4 = findViewById(R.id.date);
        s = findViewById(R.id.spinner);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item,courses);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(adapter);

        s.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String c = courses[position];
                if("MCA".equals(c)){
                    fee = 10000;
                }else if("MBA".equals(c)){
                    fee = 20000;
                }else if("MTECH".equals(c)){
                    fee = 30000;
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    public void submit(View v){
        String message = "id:"+e1.getText().toString()+"\nName:"+e2.getText().toString()+"\nAddress:"+e3.getText().toString()+"\nDOB:"+e4.getText().toString()+"\nFee:"+String.valueOf(fee);
        new AlertDialog.Builder(Pgm11.this)
                .setTitle("Caption")
                .setMessage(message)
                .setPositiveButton("ok",(which,dialog)->{})
                .show();
    }
}