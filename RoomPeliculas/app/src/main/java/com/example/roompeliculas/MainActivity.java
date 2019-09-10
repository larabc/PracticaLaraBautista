package com.example.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.actionbar_title);

    }


    //Per afegir la fletxa a l'esquerra superior de la pantalla
    @Override

    public boolean onSupportNavigateUp() {

        finish();

        return true;

    }

    //Per afegir el menu a l'actionbar de l'activity (dreta)
    @Override

    public boolean onCreateOptionsMenu(Menu menu) {

// Inflate the menu; this adds items to the action bar

        getMenuInflater().inflate(R.menu.main_menu, menu);

        return true;

    }

    @Override

    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case R.id.goToInspo:

                    Intent intent = new Intent(MainActivity.this, InspoActivity.class);
                    startActivity(intent);

                return (true);


            case R.id.goToAdd:

                intent = new Intent(MainActivity.this, FormActivity.class);
                startActivity(intent);

                return (true);

        }

        return (super.onOptionsItemSelected(item));

    }
}
