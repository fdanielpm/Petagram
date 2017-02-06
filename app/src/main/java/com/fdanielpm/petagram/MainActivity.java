package com.fdanielpm.petagram;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Pet> mascotas;
    private RecyclerView petList;
    private ImageButton btnStar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        /*
        Toolbar miPetToolbar = (Toolbar)  this.findViewById( R.id.appActionBar );
        setSupportActionBar( miPetToolbar );
        */
        petList = (RecyclerView) this.findViewById( R.id.rvPet );
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        petList.setLayoutManager( llm );
        initPetList();
        intAdapter();

        btnStar = (ImageButton) this.findViewById( R.id.btnStar );


    }

    public void goToFavoritePet(View v){
        if( mascotas !=null && !mascotas.isEmpty() ){
            Pet max = mascotas.get(0);
            for(Pet p: mascotas ){
                if( p.getLikes() >  max.getLikes() ){
                    max = p;
                }
            }
            if( max == null ){
                max = new Pet("Scoby Doo",R.drawable.dog01,1);
            }
            Intent intent = new Intent(this,MascotaFavorita.class);
            intent.putExtra("name",max.getName());
            intent.putExtra("photo", max.getPhoto() );
            intent.putExtra("likes",  max.getLikes() );
            this.startActivity( intent );

        }
    }

    private void intAdapter(){
        PetAdapter pa = new PetAdapter( mascotas, this );
        petList.setAdapter( pa );
    }

    private void initPetList(){
        mascotas = new ArrayList<>();
        mascotas.add( new Pet("Scoby Doo",R.drawable.dog01,1) );
        mascotas.add( new Pet("Benji",R.drawable.dog02,3) );
        mascotas.add( new Pet("Pulgoso",R.drawable.dog03,0) );
        mascotas.add( new Pet("Odie",R.drawable.dog04,5) );
        mascotas.add( new Pet("Snoppy",R.drawable.dog05,2) );
    }
}
