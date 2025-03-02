package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(this::abrirTelaInicial, 5000);
    }

    private void abrirTelaInicial() {
        Intent rota = new Intent(SplashActivity.this, MainActivity.class);
        startActivity(rota);
        finish();
    }
}
