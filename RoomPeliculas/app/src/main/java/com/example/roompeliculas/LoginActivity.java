package com.example.roompeliculas;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText et_user, et_password;
    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        et_user = findViewById(R.id.et_name);
        et_password = findViewById(R.id.et_password);

        prefs = getSharedPreferences("MyPreferences", MODE_PRIVATE);


    }

    public void login(View view) {

        if (checkFields()) {

            goToListActivity();
        }
    }

    private boolean checkFields() {

        String user = et_user.getText().toString();
        String password = et_password.getText().toString();

        boolean fieldsOk = true;
        if ("".equals(user)){
            fieldsOk = false;
            et_user.setError(getString(R.string.errEmptyUser));
            Toast.makeText(this, R.string.errEmptyLogin,Toast.LENGTH_LONG).show();
        } else if ("".equals(password)){
            fieldsOk = false;
            et_password.setError(getString(R.string.errEmptyPassword));
            Toast.makeText(this,  R.string.errEmptyLogin,Toast.LENGTH_LONG).show();
        }

        savePreferences();

        return fieldsOk;
    }

    private void savePreferences() {

        String user = et_user.getText().toString();
        String password = et_password.getText().toString();

        SharedPreferences.Editor editor = prefs.edit();
        editor.putString("user", user);
        editor.putString("password", password);

        editor.commit();
    }

    private void goToListActivity() {

        Intent intent = new Intent(LoginActivity.this, ListActivity.class);
        startActivity(intent);
    }


    public void goToWeb(View view) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse("https://www.abc.es/play/cine/peliculas"));
        startActivity(intent);

    }
}
