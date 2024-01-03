package com.example.finalexam;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Pgm10 extends AppCompatActivity {

    EditText e1, e2;
    RadioGroup rg;
    RadioButton rb;

    Button btn;

    String gender="";

    String eligible = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm10);
        e1 = findViewById(R.id.editTextText);
        e2 = findViewById(R.id.editTextText2);
        rg = findViewById(R.id.rg);
        btn = findViewById(R.id.submit);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int bid = rg.getCheckedRadioButtonId();
                rb = findViewById(bid);
                if("Male".equals(rb.getText())){
                    gender = "Male";
                }else if("Female".equals(rb.getText())){
                    gender = "Female";
                }

                if(Integer.parseInt(e2.getText().toString())>=18){
                    eligible = "eligible";
                }else{
                    eligible = "not eligible";
                }

                String message = e1.getText().toString()+"of age"+e2.getText().toString()+"is"+gender+"is"+String.valueOf(eligible)+"for voting";

                new AlertDialog.Builder(Pgm10.this)
                        .setTitle("vote status")
                        .setMessage(message)
                        .setPositiveButton("ok",(which,dialog)->{})
                        .show();

            }
        });
    }





}