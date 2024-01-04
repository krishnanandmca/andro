package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText e1, e2;

    SQLiteDatabase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);

        db = openOrCreateDatabase("login",MODE_PRIVATE,null);


    }

    public void login(View v){
        if(db.isOpen()){
            String sql = "SELECT * FROM register WHERE username='"+e1.getText().toString()+"' and password='"+e2.getText().toString()+"'";
            Cursor c = db.rawQuery(sql,null);
            if(c.getCount() > 0){
                Toast.makeText(this, "Login success", Toast.LENGTH_SHORT).show();
            }else{
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show();
            }
        }

    }
}