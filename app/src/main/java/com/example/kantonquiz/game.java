package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
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
    private String[] kantone   = {"Zürich","Bern","Luzern","Uri","Schwyz","Nidwalden","Obwalden","Glarus","Zug","Freiburg","Solothurn","Basel-Stadt","Basel-Land","Schaffhausen","AppenzellAusserrhoden","Appenzell Innerhoden","St. Gallen","Graubünden","Aargau","Thurgau","Tessin","Waadt","Wallis","Neuenburg","Genf","Jura"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        this.back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();//test
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

        while (numberOne == numberTwo){
            numberTwo = randomNumber();
        }
        while (numberTwo == numberThree){
            numberThree = randomNumber();
        }
        while (numberOne == numberThree){
            numberOne = randomNumber();
        }

        animate = AnimationUtils.loadAnimation(this,R.anim.animations);
        btnOne.startAnimation(animate);

        btnTwo.setText(kantone[numberOne]);
        btnThree.setText(kantone[numberTwo]);
        btnFour.setText(kantone[numberThree]);
        View.OnClickListener btnListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //TODO
                /*colourAnimation(btnTwo);
                colourAnimation(btnThree);
                colourAnimation(btnFour);*/
            }
        };

        btnTwo.setOnClickListener(btnListener);
        btnThree.setOnClickListener(btnListener);
        btnFour.setOnClickListener(btnListener);

    }
    private static int randomNumber(){
        int zahl = (int) ((Math.random()*((25-0)+1))+0);
        return zahl;
    }
    /*private void colourAnimation(View v){
        int colourStart= v.getSolidColor();
        int colourEnd = 0x228B22;

        ValueAnimator animate = ObjectAnimator.ofInt(v, "backgroundColor", colourStart,colourEnd);
        animate.setDuration(2000);
        animate.setEvaluator(new ArgbEvaluator());
        animate.setRepeatCount(ValueAnimator.REVERSE);
        animate.start();
    }*/

}