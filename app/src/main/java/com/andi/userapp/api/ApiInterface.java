package com.andi.userapp.api;

import com.andi.userapp.data.Login;
import com.andi.userapp.data.Problem;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {
    @GET("loginplapor.php")
    Call<Login> loginUser(
            @Query("user") String user,
            @Query("password") String password
    );
    @GET("problembyidplapor.php")
    Call<Problem> ambilDataProblem(
            @Query("idplapor") String idplapor
    );
}
