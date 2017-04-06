package com.fdanielpm.petagram.restApi.adapter;

import com.fdanielpm.petagram.restApi.ConstantesRestApi;
import com.fdanielpm.petagram.restApi.EndpointsApi;
import com.fdanielpm.petagram.restApi.deserializador.AccountDeserializador;
import com.fdanielpm.petagram.restApi.deserializador.PetDeserializador;
import com.fdanielpm.petagram.restApi.model.AccountResponse;
import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public Gson construyeGsonDeserializadorMediaRecent(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(PetResponse.class, new PetDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonnDeserializadorAccount(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(AccountResponse.class, new AccountDeserializador());
        return gsonBuilder.create();
    }
}
