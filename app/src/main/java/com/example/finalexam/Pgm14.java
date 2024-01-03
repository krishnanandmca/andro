package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;

public class Pgm14 extends AppCompatActivity {
    Button btn;
    ConstraintLayout layout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm14);

        btn = findViewById(R.id.clrBtn);
        layout = findViewById(R.id.layout);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(Pgm14.this,btn);
                popup.getMenuInflater().inflate(R.menu.popup_menu, popup.getMenu());

                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        int i = item.getItemId();
                        if(i == R.id.red){
                            layout.setBackgroundResource(R.color.red);
                        }else if(i == R.id.blue){
                            layout.setBackgroundResource(R.color.blue);
                        }else if(i == R.id.green){
                            layout.setBackgroundResource(R.color.green);
                        }
                        return false;
                    }
                });
                popup.show();
            }
        });
    }


}