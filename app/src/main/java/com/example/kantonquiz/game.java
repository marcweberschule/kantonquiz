package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

public class game extends AppCompatActivity {
    private ImageView img;
    Animation animate;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button back;
    private int questionCounter = 0;
    private int corAnswer=0;
    private String[] kantone   = {"Zürich","Bern","Luzern","Uri","Schwyz","Nidwalden","Obwalden","Glarus","Zug","Freiburg","Solothurn","Basel-Stadt","Basel-Land","Schaffhausen","AppenzellAusserrhoden","Appenzell Innerhoden","St. Gallen","Graubünden","Aargau","Thurgau","Tessin","Waadt","Wallis","Neuenburg","Genf","Jura",""};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.back = findViewById(R.id.back);

        Intent intent= getIntent();
        questionCounter = intent.getIntExtra("FIRST_INT", 0);
        corAnswer = intent.getIntExtra("SECOND_INT", 0);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        if(questionCounter > 25){
        Intent intent1 = new Intent(this , Score.class);
            intent1.putExtra("FIRST_INT", questionCounter);
            intent1.putExtra("SECOND_INT",corAnswer);
            startActivity(intent1);
            finish();
        }

        ImageView b = findViewById(R.id.img);
        switch(questionCounter + 1)
        {
            case 1:
                b.setImageResource(R.drawable.zurichwappen);
                break;
            case 2:
                b.setImageResource(R.drawable.bern);
                break;
            case 3:
                b.setImageResource(R.drawable.luzern);
                break;
            case 4:
                b.setImageResource(R.drawable.uri);
                break;
            case 5:
                b.setImageResource(R.drawable.schwyz);
                break;
            case 6:
                b.setImageResource(R.drawable.nidwalden);
                break;
            case 7:
                b.setImageResource(R.drawable.obwalden);
                break;
            case 8:
                b.setImageResource(R.drawable.glarus);
                break;
            case 9:
                b.setImageResource(R.drawable.zug);
                break;
            case 10:
                b.setImageResource(R.drawable.freiburg);
                break;
            case 11:
                b.setImageResource(R.drawable.solothurn);
                break;
            case 12:
                b.setImageResource(R.drawable.baselstadt);
                break;
            case 13:
                b.setImageResource(R.drawable.baselland);
                break;
            case 14:
                b.setImageResource(R.drawable.schaffhausen);
                break;
            case 15:
                b.setImageResource(R.drawable.appenzellausserrhoden);
                break;
            case 16:
                b.setImageResource(R.drawable.appenzellinnerrhoden);
                break;
            case 17:
                b.setImageResource(R.drawable.stgallen);
                break;
            case 18:
                b.setImageResource(R.drawable.graubunden);
                break;
            case 19:
                b.setImageResource(R.drawable.aargau);
                break;
            case 20:
                b.setImageResource(R.drawable.thurgau);
                break;
            case 21:
                b.setImageResource(R.drawable.tessin);
                break;
            case 22:
                b.setImageResource(R.drawable.waadt);
                break;
            case 23:
                b.setImageResource(R.drawable.wallis);
                break;
            case 24:
                b.setImageResource(R.drawable.neuenburg);
                break;
            case 25:
                b.setImageResource(R.drawable.genf);
                break;
            case 26:
                b.setImageResource(R.drawable.jura);
                break;
        }
        this.img = findViewById(R.id.img);
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
                if (questionCounter >= 26){
                    questionCounter = 25;
                }
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
        Intent intent = new Intent(this,game.class);
        intent.putExtra("FIRST_INT", questionCounter);
        intent.putExtra("SECOND_INT",corAnswer);
        startActivity(intent);
    }
    private static int randomNumber(){
        int zahl = (int) ((Math.random()*((25-0)+1))+0);
        return zahl;
    }

}