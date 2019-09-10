package com.example.roompeliculas.model;


import androidx.room.Entity;

@Entity(tableName = "pelicula")

public class Pelicula {

    String id;
    String title;
    String description;
    int year;
    int points;
    String image;


}
