package com.example.roompeliculas;

import android.app.Application;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.roompeliculas.model.PeliculaAPI;
import com.example.roompeliculas.retrofit.MyService;
import com.example.roompeliculas.retrofit.PeliculaAPIAdapter;
import com.example.roompeliculas.retrofit.RetrofitClientInstance;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class InspoActivity extends AppCompatActivity {
    ListView listView;
    ArrayList<PeliculaAPI> peliculasAPI;
    PeliculaAPIAdapter adapter;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inspo);
        peliculasAPI = new ArrayList<>();
        listView = findViewById(R.id.listViewAPI);
        adapter = new PeliculaAPIAdapter(this, R.layout.row2, peliculasAPI);
        listView.setAdapter(adapter);
        progressBar = findViewById(R.id.progressbar);


        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.txt_Ghibli);
        getFilmsFromServer();

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
    
    private void getFilmsFromServer() {
        MyService service = RetrofitClientInstance.getRetrofitInstance().create(MyService.class);
        Call<List<PeliculaAPI>> call = service.listPeliculasAPI();
        call.enqueue(new Callback<List<PeliculaAPI>>() {
            @Override
            public void onResponse(Call<List<PeliculaAPI>> call, Response<List<PeliculaAPI>> response) {
                peliculasAPI.clear();
                peliculasAPI.addAll(response.body());
                adapter.notifyDataSetChanged();
                progressBar.setVisibility(View.GONE);
            }

            @Override
            public void onFailure(Call<List<PeliculaAPI>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.errAPI, Toast.LENGTH_LONG).show();
            }
        });
    }

}
