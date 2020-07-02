package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class game extends AppCompatActivity {
    private ImageView img;
    private Button btnOne;
    private Button btnTwo;
    private Button btnThree;
    private Button btnFour;
    private Button back;

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