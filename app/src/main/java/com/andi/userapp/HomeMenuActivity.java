package com.andi.userapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class HomeMenuActivity extends AppCompatActivity {
    TextView textHallo;
    CardView bMenuproblem,bMenuLaporan,bLogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_menu);
        textHallo = findViewById(R.id.textHallo);
        bMenuproblem = findViewById(R.id.buttonproblem);
        bMenuLaporan = findViewById(R.id.buttonHistory);
        bLogout = findViewById(R.id.buttonlogout);
        SharedPreferences myPreferencesNama = this.getSharedPreferences("NamaLoginUser", Context.MODE_PRIVATE);
        String namaSupport = myPreferencesNama.getString("nama","-");
        textHallo.setText("Hallo "+ namaSupport);
        bMenuproblem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              /*  Intent intent = new Intent(HomeActivity.this, ProblemActivity.class);
                startActivity(intent); */
            }
        });
        bMenuLaporan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeMenuActivity.this, LaporanActivity.class);
                startActivity(intent);
            }
        });
        bLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeMenuActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
