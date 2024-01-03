package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pgm7 extends AppCompatActivity implements View.OnClickListener{
    EditText e1, e2;
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm7);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        btn = findViewById(R.id.button2);

        btn.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String username = e1.getText().toString();
        String password = e2.getText().toString();

        if(username.isEmpty() || password.isEmpty()){
            Toast.makeText(this, "Required fields", Toast.LENGTH_SHORT).show();
        }else if(!isValidate(password)){
            Toast.makeText(this, "The pattern doesn't matches ", Toast.LENGTH_SHORT).show();
        }else if("test".equals(username) && "Abcd@123".equals(password)){
            Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
        }

    }

    public boolean isValidate(String pass){
        String pattern = "^(?=.*[a-z])(?=.*[A-Z])(?=.*[@=+$_#])(?=.*\\d).{8,}$";
        return pass.matches(pattern);
    }
}