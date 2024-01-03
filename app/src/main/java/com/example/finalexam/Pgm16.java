package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.Buffer;

public class Pgm16 extends AppCompatActivity {
    SQLiteDatabase db = null;
    EditText e1,e2,e3,search;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm16);

        e1 = findViewById(R.id.e1);
        e2 = findViewById(R.id.e2);
        e3 = findViewById(R.id.e3);
        search = findViewById(R.id.search);

        db = openOrCreateDatabase("db",MODE_PRIVATE,null);

    }

    public void insert(View v){
        if(db.isOpen()){
            String tableQry = "CREATE TABLE IF NOT EXISTS EMP(id INTEGER PRIMARY KEY AUTOINCREMENT, name varchar(10), address varchar(10), phone varchar(10))";
            try{
                db.execSQL(tableQry);
                Toast.makeText(this, "Table created", Toast.LENGTH_SHORT).show();
            }catch (SQLException e){
                Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }

            String name = e1.getText().toString();
            String add = e2.getText().toString();
            String phn = e3.getText().toString();

            String insertQry = "INSERT INTO EMP(name, address, phone) VALUES('"+name+"','"+add+"','"+phn+"')";

            try{
                db.execSQL(insertQry);
                Toast.makeText(this, "Data inserted", Toast.LENGTH_SHORT).show();
            }catch(SQLException e){
                Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void display(View v){
        LinearLayout layout = findViewById(R.id.ll);
        layout.removeAllViews();

        try{
            String viewQry = "SELECT * FROM EMP";

            Cursor c = db.rawQuery(viewQry,null);

            if(c.getCount() == 0){
                Toast.makeText(this, "NO Record", Toast.LENGTH_SHORT).show();

            }else{
                while(c.moveToNext()){

                    LinearLayout rowLayout = new LinearLayout(this);
                    rowLayout.setOrientation(LinearLayout.HORIZONTAL);

                    TextView tv = new TextView(this);



                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name: "+c.getString(1).toString()+"\n");
                    buffer.append("address: "+c.getString(2).toString()+"\n");
                    buffer.append("phone: "+c.getString(3).toString()+"\n");

                    tv.setText(buffer.toString());

                    Button editButton = new Button(this);
                    editButton.setText("Edit");
                    editButton.setTag(c.getInt(0));

                    editButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = (int)v.getTag();

                            try{
                                String fetchData = "SELECT * FROM EMP WHERE id = "+id;
                                Cursor n = db.rawQuery(fetchData,null);
                                if(n.moveToFirst()){
                                    e1.setText(n.getString(1).toString());
                                    e2.setText(n.getString(2).toString());
                                    e3.setText(n.getString(3).toString());
                                }
                            }catch(SQLException e){
                                Toast.makeText(Pgm16.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    Button deleteButton = new Button(this);
                    deleteButton.setText("Delete");
                    deleteButton.setTag(c.getInt(0));

                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = (int)v.getTag();

                            try{
                                String deleteQry = "DELETE FROM EMP WHERE id = "+id;
                                db.execSQL(deleteQry);
                                Toast.makeText(Pgm16.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            }catch(SQLException e){
                                Toast.makeText(Pgm16.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });




                    rowLayout.addView(tv);
                    rowLayout.addView(editButton);
                    rowLayout.addView(deleteButton);


                    layout.addView(rowLayout);
                }
            }

        }catch(SQLException e){
            Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
        }
    }

    public void update(View v){
        if(db.isOpen()){

            String name = e1.getText().toString();
            String add = e2.getText().toString();
            String phn = e3.getText().toString();

            String insertQry = "UPDATE EMP set name='"+name+"', address='"+add+"', phone= '"+phn+"'";

            try{
                db.execSQL(insertQry);
                Toast.makeText(this, "Data updated", Toast.LENGTH_SHORT).show();
                Intent intent = getIntent();
                finish();
                startActivity(intent);
            }catch(SQLException e){
                Log.d("updateError",String.valueOf(e));
                Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
            }

        }
    }

    public void reset(View v){
        e1.setText("");
        e2.setText("");
        e3.setText("");
        search.setText("");
    }


    public void search(View v) {
        LinearLayout layout = findViewById(R.id.ll);
        layout.removeAllViews();
        int id = Integer.parseInt(search.getText().toString());
        try {
            String viewQry = "SELECT * FROM EMP WHERE id=" + id;

            Cursor c = db.rawQuery(viewQry, null);

            if (c.getCount() == 0) {
                Toast.makeText(this, "NO Record", Toast.LENGTH_SHORT).show();

            } else {
                if (c.moveToFirst()) {

                    LinearLayout rowLayout = new LinearLayout(this);
                    rowLayout.setOrientation(LinearLayout.HORIZONTAL);

                    TextView tv = new TextView(this);


                    StringBuffer buffer = new StringBuffer();
                    buffer.append("name: " + c.getString(1).toString() + "\n");
                    buffer.append("address: " + c.getString(2).toString() + "\n");
                    buffer.append("phone: " + c.getString(3).toString() + "\n");

                    tv.setText(buffer.toString());

                    Button editButton = new Button(this);
                    editButton.setText("Edit");
                    editButton.setTag(c.getInt(0));

                    editButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = (int) v.getTag();

                            try {
                                String fetchData = "SELECT * FROM EMP WHERE id = " + id;
                                Cursor n = db.rawQuery(fetchData, null);
                                if (n.moveToFirst()) {
                                    e1.setText(n.getString(1).toString());
                                    e2.setText(n.getString(2).toString());
                                    e3.setText(n.getString(3).toString());
                                }
                            } catch (SQLException e) {
                                Toast.makeText(Pgm16.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    Button deleteButton = new Button(this);
                    deleteButton.setText("Delete");
                    deleteButton.setTag(c.getInt(0));

                    deleteButton.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int id = (int) v.getTag();

                            try {
                                String deleteQry = "DELETE FROM EMP WHERE id = " + id;
                                db.execSQL(deleteQry);
                                Toast.makeText(Pgm16.this, "Data Deleted", Toast.LENGTH_SHORT).show();
                                Intent intent = getIntent();
                                finish();
                                startActivity(intent);
                            } catch (SQLException e) {
                                Toast.makeText(Pgm16.this, String.valueOf(e), Toast.LENGTH_SHORT).show();
                            }
                        }
                    });


                    rowLayout.addView(tv);
                    rowLayout.addView(editButton);
                    rowLayout.addView(deleteButton);


                    layout.addView(rowLayout);
                }
            }

        } catch (SQLException e) {
            Toast.makeText(this, String.valueOf(e), Toast.LENGTH_SHORT).show();
        }

    }


}