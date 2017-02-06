package com.fdanielpm.petagram;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by darkp on 5/02/17.
 */

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private List<Pet> mascotas;
    private Activity activity;

    public PetAdapter(List<Pet> mascotas,Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PetViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from( parent.getContext() ).inflate( R.layout.cardview_pet, parent, false);
        return new PetViewHolder( v );
    }

    @Override
    public void onBindViewHolder(final PetViewHolder holder, final int position) {
        final Pet pet = mascotas.get( position );

        holder.tvPetname.setText( pet.getName() );
        holder.imgPet.setImageResource( pet.getPhoto() );
        holder.btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pet.likes();
                Toast.makeText(activity,"Diste like a " + pet.getName() ,Toast.LENGTH_LONG).show();
                holder.tvLikes.setText( String.valueOf( pet.getLikes() ));
            }
        });
        holder.tvLikes.setText( String.valueOf( pet.getLikes() ) );
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder{
        private ImageView imgPet;
        private TextView tvPetname;
        private ImageButton btnLike;
        private TextView tvLikes;

        public PetViewHolder(View itemView){
            super(itemView);
            imgPet = (ImageView) itemView.findViewById(R.id.imgPet );
            tvPetname = (TextView) itemView.findViewById(R.id.tvPetname );
            btnLike = (ImageButton) itemView.findViewById(R.id.btnLike );
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikes );
        }
    }

}
