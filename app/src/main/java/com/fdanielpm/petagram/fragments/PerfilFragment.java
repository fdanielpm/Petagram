package com.fdanielpm.petagram.fragments;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.adapters.PetAdapter;
import com.fdanielpm.petagram.adapters.PetDetailAdapter;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    private List<Pet> mascotas;
    private RecyclerView petList;

    private ImageView ivPetPerfilDetalle;
    private TextView tvPetPerfilDetalle;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_perfil,container,false);

        ivPetPerfilDetalle = (ImageView) v.findViewById(R.id.ivPetPerfilDetalle);
        tvPetPerfilDetalle = (TextView) v.findViewById(R.id.tvPetPerfilDetalle);

        tvPetPerfilDetalle.setText("Scoby Doo");
        ivPetPerfilDetalle.setImageResource(  R.drawable.dog01 );

        petList = (RecyclerView) v.findViewById( R.id.rvPetDetail );
        GridLayoutManager lLayout = new GridLayoutManager(getActivity(), 3);

        petList.setLayoutManager( lLayout );
        initPetList();
        intAdapter();
        return v;
    }
    private void initPetList(){
        mascotas = new ArrayList<>();
        for(int i=0;i<9;i++) {
            mascotas.add(new Pet("Scoby Doo", R.drawable.dog01, 1));
        }

    }

    private void intAdapter(){
        PetDetailAdapter pda = new PetDetailAdapter( mascotas, getActivity() );
        petList.setAdapter( pda );
    }
}
