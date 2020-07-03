package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Score extends AppCompatActivity {
    private int questionCounter = 0;
    private int corAnswer=0;
    TextView question;
    TextView answer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        Intent intent= getIntent();
        questionCounter = intent.getIntExtra("FIRST_INT", 0);
        corAnswer = intent.getIntExtra("SECOND_INT", 0);

        this.question = findViewById(R.id.question);
        question.setText(questionCounter);
        this.answer = findViewById(R.id.anwser);
        answer.setText(corAnswer);
    }
}