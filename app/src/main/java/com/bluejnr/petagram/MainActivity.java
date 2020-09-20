package com.bluejnr.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    private ImageButton imgBtnFavorites;
    public PetAdapter petAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgBtnFavorites = (ImageButton) findViewById(R.id.btnFavorites);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavorite);
        setSupportActionBar(miActionBar);

        rvPets = (RecyclerView) findViewById(R.id.rvPets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(linearLayoutManager);

        imgBtnFavorites.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FavoritePets.class);
                startActivity(intent);
            }
        });

        inicializarListaContactos();
        inicializarAdaptador();

    }
    public void inicializarAdaptador(){
        petAdapter = new PetAdapter(pets, this);
        rvPets.setAdapter(petAdapter);
    }

    public void inicializarListaContactos(){
        pets = new ArrayList<>();

        pets.add(new Pet("Catty", 6, R.drawable.beaver_icon));
        pets.add(new Pet("Ronny", 5, R.drawable.dog_puppy_icon));
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Marta", 5, R.drawable.koala_icon));
        pets.add(new Pet("Lazy", 8, R.drawable.puppy_icon));
        pets.add(new Pet("Budy", 5, R.drawable.dog_puppy_icon));
    }
}