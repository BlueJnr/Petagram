package com.bluejnr.petagram;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluejnr.petagram.util.JavaMailAPI;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    public PetAdapter petAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPets = (RecyclerView) findViewById(R.id.rvPets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(linearLayoutManager);

        inicializarListaContactos();
        inicializarAdaptador();

        agregarFAB();

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.mAbout:
                Intent iAbout = new Intent(this, ActivityAbout.class);
                startActivity(iAbout);
                break;
            case R.id.mContact:
                Intent iSettings = new Intent(this, ActivityContact.class);
                startActivity(iSettings);
                break;
            case R.id.mFavorites:
                Intent iFavorites = new Intent(this, FavoritePets.class);
                startActivity(iFavorites);
                break;
        }

        return super.onOptionsItemSelected(item);
    }

    public void inicializarAdaptador() {
        petAdapter = new PetAdapter(pets, this);
        rvPets.setAdapter(petAdapter);
    }

    public void inicializarListaContactos() {
        pets = new ArrayList<>();

        pets.add(new Pet("Catty", 6, R.drawable.beaver_icon));
        pets.add(new Pet("Ronny", 5, R.drawable.dog_puppy_icon));
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Marta", 5, R.drawable.koala_icon));
        pets.add(new Pet("Lazy", 8, R.drawable.puppy_icon));
        pets.add(new Pet("Budy", 5, R.drawable.dog_puppy_icon));
    }

    public void agregarFAB() {
        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fabMiFAB);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Toast.makeText(getBaseContext(), getResources().getString(R.string.mensaje), Toast.LENGTH_SHORT).show();
                Snackbar.make(view, getResources().getString(R.string.mensaje), Snackbar.LENGTH_LONG)
                        .setAction(getResources().getString(R.string.texto_accion), new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                Log.i("SNACKBAR", "Click en Snackbar");
                            }
                        })
                        .setActionTextColor(getResources().getColor(R.color.colorPrimary))
                        .show();
            }
        });
    }
}