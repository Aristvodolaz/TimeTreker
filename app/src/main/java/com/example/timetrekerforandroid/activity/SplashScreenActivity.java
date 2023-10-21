package com.example.timetrekerforandroid.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.example.timetrekerforandroid.R;

public class SplashScreenActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_loader_layout);

        ImageView splashImageView = findViewById(R.id.splash_image);

        Animation fadeInAnimation = AnimationUtils.loadAnimation(this, R.anim.splash_anim);
        splashImageView.startAnimation(fadeInAnimation);

        new android.os.Handler().postDelayed(
                () -> {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                    finish();
                },
                3000
        );
    }
}
