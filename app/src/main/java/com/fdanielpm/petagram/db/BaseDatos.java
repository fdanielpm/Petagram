package com.fdanielpm.petagram.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.fdanielpm.petagram.pojo.Pet;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniel on 18/02/2017.
 */

public class BaseDatos extends SQLiteOpenHelper {
    private Context context;

    public BaseDatos(Context context) {
        super(context,ConstantesBaseDatos.DATABASE_NAME,null,ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String qryCreateQuery = new StringBuilder()
                                            .append("CREATE TABLE ").append( ConstantesBaseDatos.TABLE_PET )
                                            .append("(")
                                            .append( ConstantesBaseDatos.TABLE_PET_ID ).append( " INTEGER PRIMARY KEY AUTOINCREMENT, ")
                                            .append( ConstantesBaseDatos.TABLE_PET_NAME  ).append(" TEXT, ")
                                            .append( ConstantesBaseDatos.TABLE_PET_PHOTO  ).append(" INTEGER, ")
                                            .append( ConstantesBaseDatos.TABLE_PET_LIKES  ).append(" INTEGER ")
                                            .append(")")
                                            .toString();
        db.execSQL(qryCreateQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(  new StringBuilder().append("DROP TABLE IF EXIST ").append(ConstantesBaseDatos.TABLE_PET).toString() );
    }

    public List<Pet> obtenerTodasLasMascotas(){
        List<Pet> pets = new ArrayList<Pet>();
        String query = new StringBuilder().append("SELECT * FROM ").append( ConstantesBaseDatos.TABLE_PET ).toString();
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor registros = db.rawQuery(query, null);
            while (registros.moveToNext()) {
                Pet p = new Pet();
                p.setId(registros.getInt(0));
                p.setName(registros.getString(1));
                p.setPhoto(registros.getInt(2));
                p.setLikes(registros.getInt(3));
                pets.add(p);
            }
        }finally {
            db.close();
        }
        return pets;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.insert(ConstantesBaseDatos.TABLE_PET, null, contentValues);
        }finally {
            db.close();
        }
    }

    public void darLike(ContentValues contentValues,int id){
        SQLiteDatabase db = null;
        try {
            db = this.getWritableDatabase();
            db.update(ConstantesBaseDatos.TABLE_PET,contentValues,"id=" + id, null);
        }finally {
            db.close();
        }
    }

    public List<Pet> obtenerFavoritePets(int n){
        List<Pet> pets = new ArrayList<Pet>();
        String query = new StringBuilder()
                .append("SELECT * FROM ").append( ConstantesBaseDatos.TABLE_PET )
                .append(" order by ").append(ConstantesBaseDatos.TABLE_PET_LIKES)
                .append(" desc Limit ").append(n)
                .toString();
        SQLiteDatabase db = this.getWritableDatabase();
        try {
            Cursor registros = db.rawQuery(query, null);
            while (registros.moveToNext()) {
                Pet p = new Pet();
                p.setId(registros.getInt(0));
                p.setName(registros.getString(1));
                p.setPhoto(registros.getInt(2));
                p.setLikes(registros.getInt(3));
                pets.add(p);
            }
        }finally {
            db.close();
        }
        return pets;
    }

}
