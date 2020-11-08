package com.bluejnr.petagram.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bluejnr.petagram.pojo.Pet;
import com.bluejnr.petagram.R;

import java.util.ArrayList;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder>{

    ArrayList<Pet> pets;
    Activity activity;

    public PetAdapter(ArrayList<Pet> pets, Activity activity){
        this.pets = pets;
        this.activity = activity;
    }

    //Inflar el layout y lo pasara al viewholder para el obtenga los views
    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(v);
    }

    //Asocia cada elemento dela lista con cada view
    @Override
    public void onBindViewHolder(@NonNull PetViewHolder petViewHolder, int position) {
        final Pet pet = pets.get(position);
        petViewHolder.imgPhoto.setImageResource(pet.getPhoto());
        petViewHolder.tvPetNameCV.setText(pet.getName());
        petViewHolder.tvPetRatingCV.setText(Integer.toString(pet.getRating()));

        petViewHolder.btnRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(activity, "Diste tu calificación a " + pet.getName(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene mi lista
        return pets.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPhoto;
        private TextView tvPetNameCV;
        private TextView tvPetRatingCV;
        private ImageButton btnRate;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPhoto = (ImageView) itemView.findViewById(R.id.imgPhoto);
            tvPetNameCV = (TextView) itemView.findViewById(R.id.tvPetNameCV);
            tvPetRatingCV = (TextView) itemView.findViewById(R.id.tvPetRatingCV);
            btnRate = (ImageButton) itemView.findViewById(R.id.btnRate);
        }
    }
}

