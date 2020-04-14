package com.andi.userapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.andi.userapp.adapter.AdapterListView;
import com.andi.userapp.api.ApiEndpoint;
import com.andi.userapp.api.ApiInterface;
import com.andi.userapp.data.ListViewData;
import com.andi.userapp.data.ObjectProblem;
import com.andi.userapp.data.Problem;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LaporanActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    ArrayList<ListViewData> listViewData = new ArrayList<>();
    ApiInterface myapiinterface;
    Context myContext;
    ConstraintLayout loader;
    Activity myActivity;
    TextView textViewNoProblem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laporan);
        recyclerView = findViewById(R.id.recycleProblem);
        textViewNoProblem = findViewById(R.id.textViewProblem);
        SharedPreferences myPreferencesNama = this.getSharedPreferences("NamaLogin", Context.MODE_PRIVATE);
        String idSupport = myPreferencesNama.getString("id","-");
        myapiinterface = ApiEndpoint.getRetrofitInstance().create(ApiInterface.class);
        myContext = this.getApplicationContext();
        myActivity = this;
        Call<Problem> problemCall = myapiinterface.ambilDataProblem(idSupport);
        problemCall.enqueue(new Callback<Problem>() {
            @Override
            public void onResponse(Call<Problem> call, Response<Problem> response) {
                if(response.isSuccessful()){
                    String status = response.body().getStatus();
                    List<ObjectProblem> objectProblemList = response.body().getProblemList();
                    if(status.equals("sukses")){
                        if(objectProblemList.size() != 0){
                            ArrayList<ListViewData> lisproblem = new ArrayList<>();
                            Toast.makeText(myContext,objectProblemList.get(0).getNotiket(), Toast.LENGTH_LONG).show();
                            for (int i = 0; i < objectProblemList.size(); i++){
                                ListViewData listdata = new ListViewData();
                                listdata.setNotiket(objectProblemList.get(i).getNotiket());
                                listdata.setAsignto(objectProblemList.get(i).getAsignto());
                                listdata.setNamaplapor(objectProblemList.get(i).getNamaplapor());
                                listdata.setAsetid(objectProblemList.get(i).getAsetid());
                                listdata.setAsetname(objectProblemList.get(i).getAsetname());
                                listdata.setAsetserial(objectProblemList.get(i).getAsetserial());
                                listdata.setAsetbrand(objectProblemList.get(i).getAsetbrand());
                                listdata.setProblem(objectProblemList.get(i).getProblem());
                                listdata.setStatus(objectProblemList.get(i).getStatus());
                                listdata.setNotes(objectProblemList.get(i).getNotes());
                                listdata.setIdplapor(objectProblemList.get(i).getIdplapor());
                                listdata.setTgllapor(objectProblemList.get(i).getTgllapor());
                                lisproblem.add(listdata);
                            }
                            listViewData.addAll(lisproblem);
                            recyclerView.setLayoutManager(new LinearLayoutManager(myContext));
                            AdapterListView adapterListView = new AdapterListView(listViewData);
                            recyclerView.setAdapter(adapterListView);
                            adapterListView.setOnItemClickCallback(new AdapterListView.OnItemClickCallback() {
                                @Override
                                public void onItemClicked(ListViewData data) {
                                    Toast.makeText(myContext,data.getNotiket(),Toast.LENGTH_LONG)
                                            .show();
                                    Intent intent = new Intent(myActivity,DetailLaporanActivity.class);
                                    Bundle bundle = new Bundle();
                                    bundle.putString("notiket",data.getNotiket());
                                    bundle.putString("asignto",data.getAsignto());
                                    bundle.putString("namaplapor",data.getNamaplapor());
                                    bundle.putString("asetid",data.getAsetid());
                                    bundle.putString("asetname",data.getAsetname());
                                    bundle.putString("asetserial",data.getAsetserial());
                                    bundle.putString("asetbrand",data.getAsetbrand());
                                    bundle.putString("problem",data.getProblem());
                                    bundle.putString("status",data.getStatus());
                                    bundle.putString("notes",data.getNotes());
                                    bundle.putString("idplapor",data.getIdplapor());
                                    bundle.putString("tgllapor",data.getTgllapor());
                                    intent.putExtras(bundle);
                                    startActivity(intent);
                                }
                            });
                        }else{
                            textViewNoProblem.setText("Tidak Ada Aktivitas");
                            textViewNoProblem.setVisibility(View.VISIBLE);
                        }
                    }else{
                        Toast.makeText(myContext,"Data Tidak Ditemukan1", Toast.LENGTH_LONG).show();
                        textViewNoProblem.setText("Tidak Ada Aktivitas");
                        textViewNoProblem.setVisibility(View.VISIBLE);
                    }
                }else{
                    Toast.makeText(myContext,"Data Tidak Ditemukan2", Toast.LENGTH_LONG).show();
                    textViewNoProblem.setText("Tidak Ada Aktivitas");
                    textViewNoProblem.setVisibility(View.VISIBLE);
                }
            }

            @Override
            public void onFailure(Call<Problem> call, Throwable t) {
                Toast.makeText(myContext,t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
