package com.fdanielpm.petagram.restApi.model;

import com.fdanielpm.petagram.pojo.Pet;

import java.util.ArrayList;


public class PetResponse {

    private ArrayList<Pet> mascotas;

    public ArrayList<Pet> getMascotas() {
        return mascotas;
    }

    public void setMascotas(ArrayList<Pet> mascotas) {
        this.mascotas = mascotas;
    }
}
