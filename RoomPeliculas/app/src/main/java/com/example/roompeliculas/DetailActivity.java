package com.example.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.roompeliculas.controller.PeliculaController;
import com.example.roompeliculas.model.Pelicula;
import com.squareup.picasso.Picasso;

public class DetailActivity extends AppCompatActivity {

    PeliculaController controller;
    Pelicula pelicula;
    TextView tv_title, tv_description, tv_year, tv_rating;
    ImageView iv_image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        String id = getIntent().getStringExtra("idPelicula");
        controller = PeliculaController.get(this);
        pelicula = controller.getPelicula(id);

        tv_title = findViewById(R.id.tv_title);
        tv_description = findViewById(R.id.tv_description);
        tv_year = findViewById(R.id.tv_year);
        tv_rating = findViewById(R.id.tv_rating);
        iv_image = findViewById(R.id.iv_image);

        showPelicula();

    }

    private void showPelicula() {
        tv_title.setText(pelicula.getTitle());
        tv_description.setText(pelicula.getDescription());
        tv_year.setText(String.valueOf(pelicula.getYear()));
        tv_rating.setText(String.valueOf(pelicula.getRating()));
        Picasso.get().load(pelicula.getImage()).into(iv_image);
    }

    public void deleteFilm(View view) {
        controller.deletePelicula(pelicula);
        finish();
    }
}
