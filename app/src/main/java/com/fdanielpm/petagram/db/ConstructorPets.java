package com.fdanielpm.petagram.db;

import android.content.ContentValues;
import android.content.Context;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.pojo.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public class ConstructorPets {
    private Context context;

    public ConstructorPets(Context context) {
        this.context = context;
    }

    public List<Pet> obtenerDatos(){
        List<Pet> mascotas = new ArrayList<>();
        /*
        mascotas.add( new Pet(1,"Scoby Doo",R.drawable.dog01,1) );
        mascotas.add( new Pet(2,"Benji",R.drawable.dog02,3) );
        mascotas.add( new Pet(3,"Pulgoso",R.drawable.dog03,0) );
        mascotas.add( new Pet(4,"Odie",R.drawable.dog04,5) );
        mascotas.add( new Pet(5,"Snoppy",R.drawable.dog05,2) );
        mascotas.add( new Pet(6,"Beetoven",R.drawable.dog06,2) );
        */
        BaseDatos db = new BaseDatos(context);
        insertarPets(db);
        //return mascotas;
        return  db.obtenerTodasLasMascotas();
    }

    public List<Pet> obtenerFavoritePets(){
        BaseDatos db = new BaseDatos(context);
        //return  db.obtenerTodasLasMascotas();
        return db.obtenerFavoritePets( 5 );
    }

    public void petLikes(Pet pet){
        BaseDatos db = new BaseDatos(context);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES, pet.getLikes() );
        db.darLike(contentValues,pet.getId());
    }

    public void insertarPets(BaseDatos db){

        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,1);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Scoby Doo");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog01);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,2);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Benji");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog02);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,3);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Pulgoso");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog03);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,4);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Odie");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog04);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,5);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Snoppy");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog05);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_PET_ID,6);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_NAME,"Beetoven");
        contentValues.put(ConstantesBaseDatos.TABLE_PET_PHOTO,R.drawable.dog06);
        contentValues.put(ConstantesBaseDatos.TABLE_PET_LIKES,0);
        db.insertarMascota(contentValues);
    }
}
