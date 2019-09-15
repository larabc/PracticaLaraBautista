package com.example.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.roompeliculas.controller.PeliculaController;
import com.example.roompeliculas.model.Pelicula;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    ListView listview;
    PeliculaAdapter adapter;
    ArrayList<Pelicula> peliculas;
    PeliculaController controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        listview = findViewById(R.id.listView);
        controller = PeliculaController.get(this); 

        peliculas = new ArrayList<Pelicula>();
        adapter = new PeliculaAdapter(this, R.layout.row, peliculas);
        listview.setAdapter(adapter);

        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(ListActivity.this, DetailActivity.class);
                intent.putExtra("idPelicula", peliculas.get(i).getId());
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onResume() {
        super.onResume();
        showPeliculas();
    }

    private void showPeliculas() {
        peliculas.clear();
        peliculas.addAll(controller.getPeliculas());
        adapter.notifyDataSetChanged();
    }


    @Override

    public boolean onSupportNavigateUp() {

        finish();

        return true;

    }


    @Override

    public boolean onCreateOptionsMenu(Menu menu) {


        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.goToInspo:

                Intent intent = new Intent(ListActivity.this, InspoActivity.class);
                startActivity(intent);

                return (true);


            case R.id.goToAdd:

                intent = new Intent(ListActivity.this, FormActivity.class);
                startActivity(intent);

                return (true);

        }

        return (super.onOptionsItemSelected(item));

    }
}
