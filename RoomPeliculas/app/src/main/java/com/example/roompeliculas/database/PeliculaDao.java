package com.example.roompeliculas.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.roompeliculas.model.Pelicula;

import java.util.List;

@Dao
public interface PeliculaDao {

    @Query("SELECT * From pelicula")
    List<Pelicula> getPeliculas();

    @Query("SELECT * FROM pelicula where id like :uuid")
    Pelicula getPelicula(String uuid);

    @Insert
    void addPelicula(Pelicula p);

    @Delete
    void deletePelicula(Pelicula p);

    @Update
    void updatePelicula(Pelicula p);
}
