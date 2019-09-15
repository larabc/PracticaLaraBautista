package com.example.roompeliculas.retrofit;

import com.example.roompeliculas.model.PeliculaAPI;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface MyService {

    @GET("films/")
    Call <List<PeliculaAPI>> listPeliculasAPI();
}
