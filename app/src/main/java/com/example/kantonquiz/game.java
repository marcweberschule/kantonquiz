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
import android.widget.ImageView;

public class game extends AppCompatActivity {
    private ImageView img;
    Animation animate;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button back;
    private int i = 0;
    private String[] kantone   = {"Zürich","Bern","Luzern","Uri","Schwyz","Nidwalden","Obwalden","Glarus","Zug","Freiburg","Solothurn","Basel-Stadt","Basel-Land","Schaffhausen","AppenzellAusserrhoden","Appenzell Innerhoden","St. Gallen","Graubünden","Aargau","Thurgau","Tessin","Waadt","Wallis","Neuenburg","Genf","Jura"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        this.img = findViewById(R.id.img);
        this.btnOne = findViewById(R.id.correct);
        this.btnTwo = findViewById(R.id.falseOne);
        this.btnThree = findViewById(R.id.falseTwo);
        this.btnFour = findViewById(R.id.falseThree);

        int numberOne = randomNumber();
        int numberTwo = randomNumber();
        int numberThree = randomNumber();
        while (i == numberOne){
            numberOne = randomNumber();
        }
        while (i == numberTwo){
            numberTwo = randomNumber();
        }
        while (i == numberThree){
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

        /*animate = AnimationUtils.loadAnimation(this,R.anim.animations);
        btnOne.startAnimation(animate);*/

        btnTwo.setText(kantone[numberOne]);
        btnThree.setText(kantone[numberTwo]);
        btnFour.setText(kantone[numberThree]);

        View.OnClickListener btnListenerCor = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final ValueAnimator animator = new ValueAnimator();
                animator.setDuration(300);
                animator.setEvaluator(new ArgbEvaluator());
                animator.setIntValues(Color.GRAY,Color.GREEN);
                animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener(){
                    public void onAnimationUpdate(ValueAnimator animator){
                        btnOne.setBackgroundColor((int)animator.getAnimatedValue());
                    i++;
                    }
                });
                animator.start();
            }
        };
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
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
    private static int randomNumber(){
        int zahl = (int) ((Math.random()*((25-0)+1))+0);
        return zahl;
    }

}