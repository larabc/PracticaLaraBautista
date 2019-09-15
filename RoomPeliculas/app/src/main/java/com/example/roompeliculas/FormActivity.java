package com.example.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.roompeliculas.controller.PeliculaController;
import com.example.roompeliculas.model.Pelicula;

import java.util.List;

public class FormActivity extends AppCompatActivity {

    EditText et_title, et_description, et_year, et_rating, et_url;
    PeliculaController controller;
    Pelicula pelicula;
    String id;
    Button btn_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        et_title = findViewById(R.id.et_title);
        et_description = findViewById(R.id.et_description);
        et_year = findViewById(R.id.et_year);
        et_rating = findViewById(R.id.et_rating);
        et_url = findViewById(R.id.et_url);

        controller = PeliculaController.get(this);


    }

    public void createFilm(View view) {
        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        int year = Integer.parseInt(et_year.getText().toString());
        int rating = Integer.parseInt(et_rating.getText().toString());
        String image = et_url.getText().toString();

        if (checkFields()) {

                Pelicula p = new Pelicula(title, description, year, rating, image);
                controller.addPelicula(p);
                finish();
                goToListActivity();
            }


        }

    private void goToListActivity() {
        Intent intent = new Intent(FormActivity.this, ListActivity.class);
        startActivity(intent);
    }


    private boolean checkFields() {

        String title = et_title.getText().toString();
        String description = et_description.getText().toString();
        int year = Integer.parseInt(et_year.getText().toString());
        int rating = Integer.parseInt(et_rating.getText().toString());
        String url = et_url.getText().toString();

        boolean fieldsOk = true;
        if ("".equals(title)){
            fieldsOk = false;
            et_title.setError(getString(R.string.errEmptyTitle));
            Toast.makeText(this, R.string.errEmptyForm,Toast.LENGTH_LONG).show();
        } else if ("".equals(description)){
            fieldsOk = false;
            et_description.setError(getString(R.string.errEmptyDescription));
            Toast.makeText(this,  R.string.errEmptyForm,Toast.LENGTH_LONG).show();
        } else if ("".equals(year)){
            fieldsOk = false;
            et_year.setError(getString(R.string.errEmptyYear));
            Toast.makeText(this,  R.string.errEmptyForm,Toast.LENGTH_LONG).show();
        } else if ("".equals(rating)){
            fieldsOk = false;
            et_rating.setError(getString(R.string.errEmptyRating));
            Toast.makeText(this,  R.string.errEmptyForm,Toast.LENGTH_LONG).show();
        } else if (rating<0||rating>5){
            fieldsOk = false;
            et_rating.setError(getString(R.string.errEmptyRating));
        } else if ("".equals(url)){
            fieldsOk = false;
            et_url.setError(getString(R.string.errEmptyURL));
            Toast.makeText(this,  R.string.errEmptyForm,Toast.LENGTH_LONG).show();
        }


        return fieldsOk;
    }
}
