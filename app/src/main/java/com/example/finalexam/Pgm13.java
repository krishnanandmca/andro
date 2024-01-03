package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.TextView;

public class Pgm13 extends AppCompatActivity {
    EditText e1, e2;
    TextView tv;
    int res=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm13);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        tv = findViewById(R.id.tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.options_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int i = item.getItemId();
        int n = Integer.parseInt(e1.getText().toString());
        int m = Integer.parseInt(e2.getText().toString());

        if(i == R.id.add){
            res= n+m;
            tv.setText(String.valueOf(res));
        }else  if(i == R.id.sub) {
            res = n - m;
            tv.setText(String.valueOf(res));
        }else if(i==R.id.mul) {
            res = n * m;
            tv.setText(String.valueOf(res));
        }else if(i == R.id.div) {
            res = n / m;
            tv.setText(String.valueOf(res));
        }
        return false;
    }


}