package com.svalero.appaprendizaje;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.svalero.appaprendizaje.listnasa.view.List_nasa_activity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        final Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        // Cargar la 2ª pantalla
                        Intent intent = new Intent(
                                getBaseContext(), List_nasa_activity.class);
                        startActivity(intent);
                    }
                }, 3000);
    }
}