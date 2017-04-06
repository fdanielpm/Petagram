package com.fdanielpm.petagram.restApi.deserializador;

import com.fdanielpm.petagram.pojo.Account;
import com.fdanielpm.petagram.restApi.JsonKeys;
import com.fdanielpm.petagram.restApi.model.AccountResponse;
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

/**
 * Created by Daniel on 05/04/2017.
 */

public class AccountDeserializador implements JsonDeserializer<AccountResponse> {

    @Override
    public AccountResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        AccountResponse accountResponse = gson.fromJson(json, AccountResponse.class);
        JsonArray accountResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        accountResponse.setAccount(deserializarContactoDeJson(accountResponseData));
        return accountResponse;
    }


    private Account deserializarContactoDeJson(JsonArray accountResponseData){
        Account account = null;
        for (int i = 0; i < accountResponseData.size() ; i++) {
            JsonObject jsonObject = accountResponseData.get(i).getAsJsonObject();

            String id = jsonObject.get(JsonKeys.USER_ID).getAsString();
            String username = jsonObject.get(JsonKeys.USER_NAME).getAsString();
            String urlProfilePicture = jsonObject.get(JsonKeys.PROFILE_PICTURE).getAsString();
            String fullName =  jsonObject.get(JsonKeys.USER_FULLNAME).getAsString();

            account = new Account(id, username, urlProfilePicture, fullName);

        }

        return account;
    }
}
