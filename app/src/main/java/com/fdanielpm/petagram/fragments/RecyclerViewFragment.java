package com.fdanielpm.petagram.fragments;


import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.adapters.PetAdapter;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 12/02/2017.
 */

public class RecyclerViewFragment extends Fragment {
    private List<Pet> mascotas;
    private RecyclerView petList;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);


        petList = (RecyclerView) v.findViewById( R.id.rvPet );
        LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
        llm.setOrientation( LinearLayoutManager.VERTICAL );

        petList.setLayoutManager( llm );
        initPetList();
        intAdapter();
        return v;
    }

    private void intAdapter(){
        PetAdapter pa = new PetAdapter( mascotas, getActivity() );
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
