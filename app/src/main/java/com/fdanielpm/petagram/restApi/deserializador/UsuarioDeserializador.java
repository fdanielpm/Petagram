package com.fdanielpm.petagram.restApi.deserializador;

import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.fdanielpm.petagram.restApi.model.UsuarioResponse;
import com.google.gson.Gson;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

/**
 * Created by Daniel on 16/04/2017.
 */

public class UsuarioDeserializador implements JsonDeserializer<UsuarioResponse> {

    @Override
    public UsuarioResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        UsuarioResponse usuarioResponse = gson.fromJson(json, UsuarioResponse.class);

        JsonObject jo = json.getAsJsonObject();
        String id = jo.get("id").getAsString();
        String idDispositivo = jo.get("id_dispositivo").getAsString();
        String idUsuarioInstagram = jo.get("id_usuario_instagram").getAsString();
/*
        usuarioResponse.setId(id);
        usuarioResponse.setIdDispositivo(idDispositivo);
        usuarioResponse.setIdUsuarioInstagram(idUsuarioInstagram);
*/
        return usuarioResponse;
    }
}
