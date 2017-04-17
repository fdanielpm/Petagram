package com.fdanielpm.petagram.restApi.deserializador;

import com.fdanielpm.petagram.pojo.Pet;
import com.fdanielpm.petagram.restApi.JsonKeys;
import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;


public class PetDeserializador implements JsonDeserializer<PetResponse> {
    @Override
    public PetResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        PetResponse petResponse = gson.fromJson(json, PetResponse.class);
        JsonArray petResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        petResponse.setMascotas(deserializarPetDeJson(petResponseData));
        return petResponse;
    }

    private ArrayList<Pet> deserializarPetDeJson(JsonArray petResponseData){
        ArrayList<Pet> pets = new ArrayList<>();
        for (int i = 0; i < petResponseData.size() ; i++) {
            JsonObject petResponseDataObject = petResponseData.get(i).getAsJsonObject();

            JsonObject userJson     = petResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id               = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto   = userJson.get(JsonKeys.USER_FULLNAME).getAsString();

            JsonObject imageJson            = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson = petResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            int likes = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Pet petActual = new Pet();
            petActual.setId(id);
            petActual.setName(nombreCompleto);
            petActual.setUrlPhoto(urlFoto);
            petActual.setLikes(likes);

            pets.add(petActual);

        }

        return pets;
    }
}
