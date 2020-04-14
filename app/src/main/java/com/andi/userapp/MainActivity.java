package com.andi.userapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.andi.userapp.api.ApiEndpoint;
import com.andi.userapp.api.ApiInterface;
import com.andi.userapp.data.Login;
import com.andi.userapp.data.ObjecLogin;
import com.google.android.material.textfield.TextInputLayout;

import java.util.List;
import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    TextInputLayout textUsername,textPassword;
    ApiInterface myapiinterface;
    Context myContext;
    ConstraintLayout loader;
    Activity myActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textUsername = findViewById(R.id.textUsername);
        textPassword = findViewById(R.id.textPassword);
        loader = findViewById(R.id.contentLoader);
        Button butonLogin = findViewById(R.id.loginButton);
        myapiinterface = ApiEndpoint.getRetrofitInstance().create(ApiInterface.class);
        myContext = this.getApplicationContext();
        myActivity = this;
        butonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String userId = Objects.requireNonNull(textUsername.getEditText()).getText().toString();
                String passWord = Objects.requireNonNull(textPassword.getEditText()).getText().toString();
                if(!userId.isEmpty() && !passWord.isEmpty()){
                    textPassword.clearFocus();
                    loader.setVisibility(View.VISIBLE);
                    Call<Login> loginCall = myapiinterface.loginUser(userId,passWord);
                    loginCall.enqueue(new Callback<Login>() {
                        @Override
                        public void onResponse(Call<Login> call, Response<Login> response) {
                            loader.setVisibility(View.INVISIBLE);
                            List<ObjecLogin> objeckLogin = response.body().getObjeckLogins();
                            String statusLogin = response.body().getStatus();
                            if(statusLogin.equals("sukses")){
                                SharedPreferences myPreferencesNama = myActivity.getSharedPreferences("NamaLoginUser", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editmyPreferencesNama = myPreferencesNama.edit();
                                editmyPreferencesNama.putString("nama",objeckLogin.get(0).getNama());
                                editmyPreferencesNama.putString("id",objeckLogin.get(0).getId());
                                editmyPreferencesNama.apply();
                                Intent intent = new Intent(MainActivity.this,HomeMenuActivity.class);
                                startActivity(intent);
                                finish();
                            }else{
                                Toast.makeText(myContext,"Login Gagal Kamu Salah Memasukan Userid atau Password", Toast.LENGTH_LONG).show();
                            }

                        }

                        @Override
                        public void onFailure(Call<Login> call, Throwable t) {
                            loader.setVisibility(View.INVISIBLE);
                            Toast.makeText(myContext,t.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
                }else  if(userId.isEmpty()){
                    textUsername.getEditText().setError("User ID tidak boleh kosong");
                }else{
                    textPassword.getEditText().setError("Password tidak boleh kosong");
                }
            }
        });
    }
}
