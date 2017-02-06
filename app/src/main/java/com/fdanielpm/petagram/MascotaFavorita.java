package com.fdanielpm.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MascotaFavorita extends AppCompatActivity {

    private TextView tvPetnameFav;
    private TextView tvLikesFav;
    private ImageView imgPetFav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascota_favorita);

        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        imgPetFav = (ImageView) findViewById(R.id.imgPetFav);
        tvPetnameFav = (TextView) findViewById(R.id.tvPetnameFav);
        tvLikesFav = (TextView) findViewById(R.id.tvLikesFav);

        if( this.getIntent() !=null && this.getIntent().getExtras()!=null ){
            Bundle parametros = this.getIntent().getExtras();

            String nombre = parametros.getString("name");
            tvPetnameFav.setText( nombre );
            int photo = parametros.getInt("photo");
            imgPetFav.setImageResource( photo );

            int likes = parametros.getInt("likes");
            tvLikesFav.setText( String.valueOf( likes ) );
        }
    }
}
