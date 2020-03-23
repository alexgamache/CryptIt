package com.example.ollux.cryptit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.util.TimerTask;
import java.util.Timer;

public class SplashScreen extends AppCompatActivity {

    Timer timer;
    private ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashscreen);

        img = (ImageView)findViewById(R.id.imageView);
        Animation animFadeIn = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_in);
        Animation animFadeOut = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.fade_out);
        animFadeOut.setStartOffset(3000);
        img.startAnimation(animFadeIn);
        AnimationSet s = new AnimationSet(false);//false means don't share interpolators
        s.addAnimation(animFadeIn);
        s.addAnimation(animFadeOut);
        s.setStartOffset(1000);
        img.startAnimation(s);
        img.setVisibility(View.INVISIBLE);

        timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }, 6000);
    }
}
