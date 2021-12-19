package com.example.reto_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.opcion1) {

            Intent segundaPantalla = new Intent(this, MainActivity3.class);
            startActivity(segundaPantalla);
        }
        if (id == R.id.opcion2) {
            Intent terceraPantalla = new Intent(this, MainActivity4.class);
            startActivity(terceraPantalla);
        }

        return super.onOptionsItemSelected(item);
    }

}