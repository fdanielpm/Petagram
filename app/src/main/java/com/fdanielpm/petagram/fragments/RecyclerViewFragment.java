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
import com.fdanielpm.petagram.presentador.RecyclerViewFragmentPresenter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 12/02/2017.
 */

public class RecyclerViewFragment extends Fragment implements IRecyclerViewFragmentView {
    //private List<Pet> mascotas;
    private RecyclerView petList;
    private RecyclerViewFragmentPresenter recyclerViewFragmentPresenter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        //return super.onCreateView(inflater, container, savedInstanceState);
        View v = inflater.inflate(R.layout.fragment_recyclerview,container,false);
        petList = (RecyclerView) v.findViewById( R.id.rvPet );

        recyclerViewFragmentPresenter = new RecyclerViewFragmentPresenter(this, getContext() );
       // initPetList();
        //intAdapter();
        return v;
    }
/*
    private void intAdapter(){
    }
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
        LinearLayoutManager llm = new LinearLayoutManager( getActivity() );
        llm.setOrientation( LinearLayoutManager.VERTICAL );
        petList.setLayoutManager( llm );
    }

    @Override
    public PetAdapter crearAdaptador(List<Pet> pets) {
        PetAdapter pa = new PetAdapter( pets, getActivity() );
        return pa;
    }

    @Override
    public void inicializarAdaptadorRV(PetAdapter adaptador) {
        petList.setAdapter( adaptador );
    }
}
