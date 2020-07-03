package com.example.kantonquiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button play;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NotificationCompat.Builder notification = new NotificationCompat.Builder(this);
        notification.setContentTitle("Zeit zum Üben");
        notification.setContentText("Du hast seit 6 Stunden kein Kanton Quiz gespielt.");
        play=findViewById(R.id.play);
        play.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                newSite();
            }
        });

        }
        public void newSite(){
            Intent intent = new Intent(this,game.class);
            startActivity(intent);
        }
    }
