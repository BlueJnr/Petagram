package com.bluejnr.petagram;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.bluejnr.petagram.adapter.PetAdapter;
import com.bluejnr.petagram.pojo.Pet;

import java.util.ArrayList;

public class FavoritePets extends AppCompatActivity {

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    public PetAdapter petAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorite_pets);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarFavorite);
        setSupportActionBar(miActionBar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        rvPets = (RecyclerView) findViewById(R.id.rvFavoritePets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(linearLayoutManager);

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
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Marta", 5, R.drawable.koala_icon));
        pets.add(new Pet("Lazy", 8, R.drawable.puppy_icon));
        pets.add(new Pet("Budy", 5, R.drawable.dog_puppy_icon));
    }
}
