package com.fdanielpm.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

import com.fdanielpm.petagram.adapters.PetFavoriteAdapter;
import com.fdanielpm.petagram.pojo.Pet;
import com.fdanielpm.petagram.presentador.RecyclerViewMascotaFavoritaPresenter;

import java.util.ArrayList;
import java.util.List;

public class MascotaFavorita extends AppCompatActivity  implements IRecyclerViewMascotaFavorita{
    //private List<Pet> mascotas;

    private RecyclerViewMascotaFavoritaPresenter recyclerViewMascotaFavoritaPresenter;
    private RecyclerView petList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);
        petList = (RecyclerView)findViewById(R.id.rvFavoritePet);

        recyclerViewMascotaFavoritaPresenter = new RecyclerViewMascotaFavoritaPresenter(this, this.getBaseContext());

        generarLinearLayoutVertical();
        /*
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation( LinearLayoutManager.VERTICAL );
        petList.setLayoutManager( llm );
        */
      //  initPetList();
      //  intAdapter();
        /*
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgPetFav = (ImageView) findViewById(R.id.imgPetFav);
        tvPetnameFav = (TextView) findViewById(R.id.tvPetnameFav);
        tvLikesFav = (TextView) findViewById(R.id.tvLikesFav);

        if( this.getIntent() !=null && this.getIntent().getExtras()!=null ){
            Bundle parametros = this.getIntent().getExtras();

            String nombre = parametros.getString("name");
            tvPetnameFav.setText( nombre );
            int photo = parametros.getInt("photo");
            imgPetFav.setImageResource( photo );

            int likes = parametros.getInt("likes");
            tvLikesFav.setText( String.valueOf( likes ) );
        }
        */
    }
/*
    private void intAdapter(){
        PetFavoriteAdapter pa = new PetFavoriteAdapter( mascotas,this );
        petList.setAdapter( pa );
    }
*/
    /*
    private void initPetList(){
        mascotas = new ArrayList<>();
        mascotas.add( new Pet(1,"Scoby Doo",R.drawable.dog01,1) );
        mascotas.add( new Pet(2,"Benji",R.drawable.dog02,3) );
        mascotas.add( new Pet(3,"Pulgoso",R.drawable.dog03,0) );
        mascotas.add( new Pet(4,"Odie",R.drawable.dog04,5) );
        mascotas.add( new Pet(5,"Snoppy",R.drawable.dog05,2) );
        mascotas.add( new Pet(6,"Beetoven",R.drawable.dog06,2) );
    }
*/
    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager( this );
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        petList.setLayoutManager( llm );
    }

    @Override
    public PetFavoriteAdapter crearAdaptador(List<Pet> pets) {
        PetFavoriteAdapter pa = new PetFavoriteAdapter( pets,this );
        petList.setAdapter( pa );
        return pa;
    }

    @Override
    public void inicializarAdaptadorRV(PetFavoriteAdapter adaptador) {
        petList.setAdapter( adaptador );
    }
}
