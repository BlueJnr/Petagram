package com.bluejnr.petagram.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bluejnr.petagram.pojo.Pet;
import com.bluejnr.petagram.R;
import com.bluejnr.petagram.adapter.PetProfileAdapter;

import java.util.ArrayList;

public class ProfileFragment extends Fragment {

    ArrayList<Pet> pets;
    private RecyclerView rvPetsProfile;
    public PetProfileAdapter petProfileAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        rvPetsProfile = (RecyclerView) view.findViewById(R.id.rvPetsProfile);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 3);
        gridLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        rvPetsProfile.setLayoutManager(gridLayoutManager);

        inicializarListaContactos();
        inicializarAdaptador();

        return view;
    }

    public void inicializarAdaptador() {
        petProfileAdapter = new PetProfileAdapter(pets, getActivity());
        rvPetsProfile.setAdapter(petProfileAdapter);
    }

    public void inicializarListaContactos() {
        pets = new ArrayList<>();

        pets.add(new Pet("Boby", 6, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 5, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 5, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 5, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 6, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 8, R.drawable.dog_mask_icon));
        pets.add(new Pet("Boby", 5, R.drawable.dog_mask_icon));
    }
}