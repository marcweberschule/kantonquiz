package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameP2 extends AppCompatActivity {
    Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_p2);

        Intent intent= getIntent();
        final int i = intent.getIntExtra("FIRST_INT", 0);
        final int corAnswers = intent.getIntExtra("SECOND_INT", 0);

        this.btn = findViewById(R.id.testBtn);
        btn.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view) {
                System.out.println(i);
                System.out.println(corAnswers);
            }
        });

    }
}