package com.bluejnr.petagram;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PetProfileAdapter extends RecyclerView.Adapter<PetProfileAdapter.PetProfileViewHolder>{

    ArrayList<Pet> pets;
    Activity activity;

    public PetProfileAdapter(ArrayList<Pet> pets, Activity activity) {
        this.pets = pets;
        this.activity = activity;
    }

    @NonNull
    @Override
    public PetProfileViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet_profile, parent, false);
        return new PetProfileViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PetProfileViewHolder holder, int position) {
        final Pet pet = pets.get(position);
        holder.imgPetProfilePhoto.setImageResource(pet.getPhoto());
        holder.tvPetProfileRating.setText(Integer.toString(pet.getRating()));

    }

    @Override
    public int getItemCount() {
        return pets.size();
    }

    public static class PetProfileViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPetProfilePhoto;
        private TextView tvPetProfileRating;

        public PetProfileViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPetProfilePhoto = (ImageView) itemView.findViewById(R.id.imgPetProfilePhoto);
            tvPetProfileRating = (TextView) itemView.findViewById(R.id.tvPetProfileRating);
        }
    }
}
