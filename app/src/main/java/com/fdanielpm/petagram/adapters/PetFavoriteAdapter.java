package com.fdanielpm.petagram.adapters;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public class PetFavoriteAdapter extends RecyclerView.Adapter<PetFavoriteAdapter.PetViewHolder> {

    private List<Pet> lstPets;
    private Activity activity;


    public PetFavoriteAdapter(List<Pet> lstPets, Activity activity){
        this.lstPets = lstPets;
        this.activity = activity;
    }


    @Override
    public PetFavoriteAdapter.PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.activity_mascota_favorita_recyclerview, parent, false);
        return new PetFavoriteAdapter.PetViewHolder( v );
    }

    @Override
    public void onBindViewHolder(final PetFavoriteAdapter.PetViewHolder holder, final int position) {
        final Pet pet = lstPets.get( position );

        holder.tvPetNameFav.setText( pet.getName() );
        holder.imgPetFav.setImageResource( pet.getPhoto() );
        holder.tvLikesFav.setText( String.valueOf( pet.getLikes() ) );
    }

    @Override
    public int getItemCount() {
        return lstPets.size();
    }


    public static class PetViewHolder extends RecyclerView.ViewHolder{

        private ImageView imgPetFav;
        private TextView tvPetNameFav;
        private TextView tvLikesFav;

        public PetViewHolder(View itemView){
            super(itemView);
            imgPetFav = (ImageView) itemView.findViewById(R.id.imgPetFav );
            tvPetNameFav = (TextView) itemView.findViewById(R.id.tvPetNameFav );
            tvLikesFav = (TextView) itemView.findViewById(R.id.tvLikesFav );
        }
    }
}
