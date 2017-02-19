package com.fdanielpm.petagram.presentador;

import android.content.Context;

import com.fdanielpm.petagram.IRecyclerViewMascotaFavorita;
import com.fdanielpm.petagram.db.ConstructorPets;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.List;

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
        obtenerPetsBaseDatos();
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
}
