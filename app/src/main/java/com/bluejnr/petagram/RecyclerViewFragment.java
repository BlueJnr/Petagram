package com.bluejnr.petagram;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

public class RecyclerViewFragment extends Fragment {

    ArrayList<Pet> pets;
    private RecyclerView rvPets;
    public PetAdapter petAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);

        rvPets = (RecyclerView) view.findViewById(R.id.rvPets);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPets.setLayoutManager(linearLayoutManager);

        inicializarListaContactos();
        inicializarAdaptador();

        return view;
    }

    public void inicializarAdaptador() {
        petAdapter = new PetAdapter(pets, getActivity());
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
}