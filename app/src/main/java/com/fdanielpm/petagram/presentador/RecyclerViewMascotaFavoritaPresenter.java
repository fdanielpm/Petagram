package com.fdanielpm.petagram.presentador;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import com.fdanielpm.petagram.IRecyclerViewMascotaFavorita;
import com.fdanielpm.petagram.db.ConstructorPets;
import com.fdanielpm.petagram.pojo.Pet;
import com.fdanielpm.petagram.restApi.EndpointsApi;
import com.fdanielpm.petagram.restApi.adapter.RestApiAdapter;
import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Daniel on 18/02/2017.
 */

public class RecyclerViewMascotaFavoritaPresenter implements  IRecyclerViewMascotaFavoritaPresenter {

    private IRecyclerViewMascotaFavorita iRecyclerViewMascotaFavorita;
    private Context context;
    private ConstructorPets constructorPets;
    private List<Pet> mascotas;

    public RecyclerViewMascotaFavoritaPresenter(IRecyclerViewMascotaFavorita iRecyclerViewMascotaFavorita, Context context) {
        this.iRecyclerViewMascotaFavorita = iRecyclerViewMascotaFavorita;
        this.context = context;
       // obtenerPetsBaseDatos();
        obtenerMediosRecientes();
    }


    @Override
    public void obtenerPetsBaseDatos() {
        constructorPets = new ConstructorPets( context );
        mascotas = constructorPets.obtenerFavoritePets();
        mostrarPetsRV();
    }

    @Override
    public void mostrarPetsRV() {
        iRecyclerViewMascotaFavorita.inicializarAdaptadorRV( iRecyclerViewMascotaFavorita.crearAdaptador(mascotas) );
        iRecyclerViewMascotaFavorita.generarLinearLayoutVertical();
    }

    public void obtenerMediosRecientes() {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        Call<PetResponse> contactoResponseCall = endpointsApi.getRecentMedia();

        contactoResponseCall.enqueue(new Callback<PetResponse>() {
            @Override
            public void onResponse(Call<PetResponse> call, Response<PetResponse> response) {
                PetResponse petResponse = response.body();
                mascotas = petResponse.getMascotas();
                mostrarPetsRV();
            }

            @Override
            public void onFailure(Call<PetResponse> call, Throwable t) {
                Toast.makeText(context, "¡Al pasó en la conexión! Intenta de nuevo", Toast.LENGTH_LONG).show();
                Log.e("FALLO LA CONEXION", t.toString());
            }
        });



    }
}
