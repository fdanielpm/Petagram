package com.fdanielpm.petagram.restApi;

import com.fdanielpm.petagram.restApi.model.AccountResponse;
import com.fdanielpm.petagram.restApi.model.PetResponse;
import com.fdanielpm.petagram.restApi.model.UsuarioResponse;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia(@Path("userid") String userId);

    @GET(ConstantesRestApi.URL_FIND_USER)
    Call<AccountResponse> getAccount(@Query("q") String account);


    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN_FIREBASE)
    Call<UsuarioResponse> registrarTokenID(@Field("id_dispositivo") String idDispositivo, @Field("id_usuario_instagram") String idUsuarioInstagram);
}
