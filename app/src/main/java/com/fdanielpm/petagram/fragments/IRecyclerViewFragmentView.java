package com.fdanielpm.petagram.fragments;

import com.fdanielpm.petagram.adapters.PetAdapter;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public interface IRecyclerViewFragmentView {
    public void generarLinearLayoutVertical();
    public PetAdapter crearAdaptador(List<Pet> pets);
    public void inicializarAdaptadorRV(PetAdapter adaptador);
}
