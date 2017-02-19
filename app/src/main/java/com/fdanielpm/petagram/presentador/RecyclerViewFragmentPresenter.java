package com.fdanielpm.petagram.presentador;

import android.content.Context;

import com.fdanielpm.petagram.db.ConstructorPets;
import com.fdanielpm.petagram.fragments.IRecyclerViewFragmentView;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public class RecyclerViewFragmentPresenter  implements IRecyclerViewFragmentPresenter{

    private IRecyclerViewFragmentView iRecyclerViewFragmentView;
    private Context context;
    private ConstructorPets constructorPets;
    private List<Pet> mascotas;

    public  RecyclerViewFragmentPresenter(IRecyclerViewFragmentView iRecyclerViewFragmentView, Context context){
        this.iRecyclerViewFragmentView = iRecyclerViewFragmentView;
        this.context = context;
        obtenerPetsBaseDatos();
    }

    @Override
    public void obtenerPetsBaseDatos() {
        constructorPets = new ConstructorPets( context );
        mascotas = constructorPets.obtenerDatos();
        mostrarPetsRV();
    }

    @Override
    public void mostrarPetsRV() {
        iRecyclerViewFragmentView.inicializarAdaptadorRV( iRecyclerViewFragmentView.crearAdaptador(mascotas)  );
        iRecyclerViewFragmentView.generarLinearLayoutVertical();
    }
}
