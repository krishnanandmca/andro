package com.example.finalexam;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.EditText;

import java.util.Locale;

public class pgm9 extends AppCompatActivity {
    TextToSpeech ts;
    EditText t;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pgm9);
        t = findViewById(R.id.t);
        ts = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status != TextToSpeech.ERROR){
                    ts.setLanguage(Locale.UK);
                }
            }
        });
    }


    public void speak(View v){
        ts.speak(t.getText().toString(),TextToSpeech.QUEUE_FLUSH,null);
    }
}