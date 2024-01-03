package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Pgm3 extends AppCompatActivity {

    EditText e1, e2;
    TextView t;

    int res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm3);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        t = findViewById(R.id.res);

    }

    public void calc(View v){
        int n = Integer.parseInt(e1.getText().toString());
        int m = Integer.parseInt(e2.getText().toString());

        int id = v.getId();
        if(id == R.id.add){
            res = n+m;
            t.setText(String.valueOf(res));
        }else if(id == R.id.sub){
            res = n-m;
            t.setText(String.valueOf(res));
        }

    }

}