package com.fdanielpm.petagram.fragments;


import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.support.v4.app.Fragment;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.adapters.PetAdapter;
import com.fdanielpm.petagram.adapters.PetDetailAdapter;
import com.fdanielpm.petagram.pojo.Pet;
import com.fdanielpm.petagram.restApi.EndpointsApi;
import com.fdanielpm.petagram.restApi.adapter.RestApiAdapter;
import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


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
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<PetResponse> petResponseCall = endpointsApi.getRecentMedia();

        petResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                mascotas = petResponse.getMascotas();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText( getContext(), "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });

    }

    private void intAdapter(){
        PetDetailAdapter pda = new PetDetailAdapter( mascotas, getActivity() );
        petList.setAdapter( pda );
    }
}
