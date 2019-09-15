package com.example.roompeliculas.controller;

import android.content.Context;

import androidx.room.Room;

import com.example.roompeliculas.database.PeliculaDao;
import com.example.roompeliculas.database.PeliculaDatabase;
import com.example.roompeliculas.model.Pelicula;

import java.util.List;

public class PeliculaController {
    private static PeliculaController controller;
    private PeliculaDao mPeliculaDao;
    private PeliculaController(Context context) {

        Context appContext = context.getApplicationContext();
        PeliculaDatabase database = Room.databaseBuilder(appContext, PeliculaDatabase.class, "pelicula").allowMainThreadQueries().build();
        mPeliculaDao = database.getPeliculaDao();
    }


    public static PeliculaController get(Context context) {
        if (controller == null) {
            controller = new PeliculaController(context);
        }
        return controller;
    }    public List<Pelicula> getPeliculas() {
        return mPeliculaDao.getPeliculas();
    }    public Pelicula getPelicula(String id) {
        return mPeliculaDao.getPelicula(id);
    }    public void addPelicula(Pelicula pelicula) {
        mPeliculaDao.addPelicula(pelicula);
    }    public void deletePelicula(Pelicula pelicula) {
        mPeliculaDao.deletePelicula(pelicula);
    }
}
