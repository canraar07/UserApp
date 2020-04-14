package com.andi.userapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.andi.userapp.api.ApiEndpoint;
import com.andi.userapp.api.ApiInterface;

public class DetailLaporanActivity extends AppCompatActivity {
    TextView textDetailNotiket,textDetailTglTiket,textDetailStatus,textDetailAsetId,textDetailSerialAset;
    TextView textDetailAsetName, textDetailAsetBrand, textDetailProblem, texDetailNotes, textLabelNotes;
    String statusText;
    RadioGroup rdStatus;
    Button btUbhStatus;
    ApiInterface myapiinterface;
    Context myContext;
    ConstraintLayout loader;
    Activity myActivity;
    EditText editTextNotes;
    Bundle bundle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_laporan);
        bundle = getIntent().getExtras();
        textDetailNotiket = findViewById(R.id.textDetailNotiket);
        textDetailTglTiket = findViewById(R.id.textDetailTglTiket);
        textDetailStatus = findViewById(R.id.textDetailStatus);
        textDetailAsetId = findViewById(R.id.textDetailAsetId);
        textDetailSerialAset = findViewById(R.id.textDetailSerialAset);
        textDetailAsetName = findViewById(R.id.textDetailAsetName);
        textDetailAsetBrand = findViewById(R.id.textDetailAsetBrand);
        textDetailProblem = findViewById(R.id.textDetailProblem);
        texDetailNotes = findViewById(R.id.texDetailNotes);
        myapiinterface = ApiEndpoint.getRetrofitInstance().create(ApiInterface.class);
        myContext = this.getApplicationContext();
        myActivity = this;
        if(bundle.getString("status").equals("3")){
            statusText = "Belum Selesai";
        }else if(bundle.getString("status").equals("2")){
            statusText = "Dalam Pengerjaan";
        }else if(bundle.getString("status").equals("1")){
            statusText = "Selesai";
        }else if(bundle.getString("status").equals("4")){
            statusText = "Dalam Antrian";
        }
        textDetailNotiket.setText("No Tiket : " + bundle.getString("notiket"));
        textDetailTglTiket.setText("Tanggal Tiket : " + bundle.getString("tgllapor"));
        textDetailStatus.setText("Status : " + statusText);
        textDetailAsetId.setText("Aset ID : "+bundle.getString("asetid"));
        textDetailSerialAset.setText("Serial Number : " + bundle.getString("asetserial"));
        textDetailAsetName.setText( "Nama Aset : " + bundle.getString("asetname"));
        textDetailAsetBrand.setText("Brand : " + bundle.getString("asetbrand"));
        textDetailProblem.setText("Problem : " + bundle.getString("problem"));
        texDetailNotes.setText("Notes : " + bundle.getString("notes"));
    }
}
