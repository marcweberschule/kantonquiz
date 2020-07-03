package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class gameP3 extends AppCompatActivity {
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button back;
    //public static final String nrOneText= "com.example.kantonquiz.nrOneText";
    //public static final String nrTwoText= "com.example.kantonquiz.nrTwoText";
    private int questionCounter = 0;
    private int corAnswer=0;
    private String[] kantone   = {"Zürich","Bern","Luzern","Uri","Schwyz","Nidwalden","Obwalden","Glarus","Zug","Freiburg","Solothurn","Basel-Stadt","Basel-Land","Schaffhausen","AppenzellAusserrhoden","Appenzell Innerhoden","St. Gallen","Graubünden","Aargau","Thurgau","Tessin","Waadt","Wallis","Neuenburg","Genf","Jura"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_p3);

        Intent intent= getIntent();
        questionCounter = intent.getIntExtra("FIRST_INT", 0);
        corAnswer = intent.getIntExtra("SECOND_INT", 0);

        this.back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        /*this.button = findViewById(R.id.testBtn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                System.out.println(questionCounter);
                System.out.println(corAnswer);
            }
        });*/
        this.btnOne = findViewById(R.id.correct);
        this.btnTwo = findViewById(R.id.falseOne);
        this.btnThree = findViewById(R.id.falseTwo);
        this.btnFour = findViewById(R.id.falseThree);

        int numberOne = randomNumber();
        int numberTwo = randomNumber();
        int numberThree = randomNumber();
        while (questionCounter == numberOne){
            numberOne = randomNumber();
        }
        while (questionCounter == numberTwo){
            numberTwo = randomNumber();
        }
        while (questionCounter == numberThree){
            numberThree = randomNumber();
        }
        while (numberOne == numberTwo){
            numberTwo = randomNumber();
        }
        while (numberTwo == numberThree){
            numberThree = randomNumber();
        }
        while (numberOne == numberThree){
            numberOne = randomNumber();
        }


        btnOne.setText(kantone[questionCounter]);
        btnTwo.setText(kantone[numberOne]);
        btnThree.setText(kantone[numberTwo]);
        btnFour.setText(kantone[numberThree]);

        View.OnClickListener btnListenerCor = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionCounter++;
                corAnswer++;
                final ValueAnimator animator = new ValueAnimator();
                animator.setDuration(300);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setIntValues(Color.GRAY,Color.GREEN);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    public void onAnimationUpdate(ValueAnimator animator){
                        btnOne.setBackgroundColor((int)animator.getAnimatedValue());

                        nextQuestion();
                    }
                });
                animator.start();
            }
        };
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override

            public void onClick(View view) {
                questionCounter++;
                nextQuestion();
                final ValueAnimator animator = new ValueAnimator();
                animator.setDuration(300);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setIntValues(Color.GRAY,Color.RED);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    public void onAnimationUpdate(ValueAnimator animator){
                        btnTwo.setBackgroundColor((int)animator.getAnimatedValue());

                    }
                });
                animator.start();
            }
        };
        View.OnClickListener btnListenerTwo = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionCounter++;
                nextQuestion();
                final ValueAnimator animator = new ValueAnimator();
                animator.setDuration(300);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setIntValues(Color.GRAY,Color.RED);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    public void onAnimationUpdate(ValueAnimator animator){
                        btnThree.setBackgroundColor((int)animator.getAnimatedValue());

                    }

                });
                animator.start();
            }
        };
        View.OnClickListener btnListenerThree = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questionCounter++;
                nextQuestion();
                final ValueAnimator valueAnimator = new ValueAnimator();
                final ValueAnimator animator = new ValueAnimator();
                animator.setDuration(300);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setIntValues(Color.GRAY,Color.RED);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    public void onAnimationUpdate(ValueAnimator animator){
                        btnFour.setBackgroundColor((int)animator.getAnimatedValue());

                    }
                });
                animator.start();
            }
        };
        btnOne.setOnClickListener(btnListenerCor);
        btnTwo.setOnClickListener(btnListener);
        btnThree.setOnClickListener(btnListenerTwo);
        btnFour.setOnClickListener(btnListenerThree);

    }
    public void nextQuestion(){
        Intent intent = new Intent(this,gameP4.class);
        intent.putExtra("FIRST_INT", questionCounter);
        intent.putExtra("SECOND_INT",corAnswer);
        startActivity(intent);
    }
    private static int randomNumber(){
        int zahl = (int) ((Math.random()*((25-0)+1))+0);
        return zahl;
    }
}

