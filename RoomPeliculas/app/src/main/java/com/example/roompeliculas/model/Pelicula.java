package com.example.roompeliculas.model;


import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import java.util.UUID;

@Entity(tableName = "pelicula")

public class Pelicula {
    @PrimaryKey
    @NonNull
    String id;

    String title;
    String description;
    int year;
    int rating;
    String image;

    public Pelicula() {
        id = UUID.randomUUID().toString();
    }

    public Pelicula(String title, String description, int year, int rating, String image) {
        id = UUID.randomUUID().toString();
        this.title = title;
        this.description = description;
        this.year = year;
        this.rating = rating;
        this.image = image;
    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }


}
