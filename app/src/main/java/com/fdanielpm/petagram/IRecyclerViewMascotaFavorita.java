package com.fdanielpm.petagram;

import com.fdanielpm.petagram.adapters.PetFavoriteAdapter;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public interface IRecyclerViewMascotaFavorita {

    public void generarLinearLayoutVertical();
    public PetFavoriteAdapter crearAdaptador(List<Pet> pets);
    public void inicializarAdaptadorRV(PetFavoriteAdapter adaptador);
}
