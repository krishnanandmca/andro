package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText e1, e2;

    SQLiteDatabase db = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);

        db = openOrCreateDatabase("login",MODE_PRIVATE,null);
        Toast.makeText(this, "db created", Toast.LENGTH_SHORT).show();


    }

    public void register(View v){

        if(db.isOpen()){
            String sql = "CREATE TABLE IF NOT EXISTS register(id INTEGER PRIMARY KEY AUTOINCREMENT, username varchar(10), password varchar(10))";
            db.execSQL(sql);
            Toast.makeText(this, "table created", Toast.LENGTH_SHORT).show();

            try{
                String registersql = "INSERT INTO register(username, password) VALUES('"+e1.getText().toString()+"','"+e2.getText().toString()+"')";
                db.execSQL(registersql);
                Toast.makeText(this, "registered", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);

            }catch(SQLException e){
                Log.d("error",String.valueOf(e));
                Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }

        }
    }
}