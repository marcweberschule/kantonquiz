package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private int questionCounter;
    private int corAnswer;
    TextView question;
    TextView answer;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent= getIntent();
        questionCounter = intent.getIntExtra("FIRST_INT", 0);
        corAnswer = intent.getIntExtra("SECOND_INT", 0);

        this.question = findViewById(R.id.question);
        question.setText(String.valueOf(questionCounter));
        this.answer = findViewById(R.id.anwser);
        answer.setText(String.valueOf(corAnswer));

        this.button = findViewById(R.id.back);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToMenu();
                finish();
            }
        });

    }
    public void backToMenu(){
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}