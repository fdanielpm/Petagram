package com.fdanielpm.petagram.restApi;

import com.fdanielpm.petagram.restApi.model.AccountResponse;
import com.fdanielpm.petagram.restApi.model.PetResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;


public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<PetResponse> getRecentMedia();

    @GET(ConstantesRestApi.URL_FIND_USER)
    Call<AccountResponse> getAccount(@Query("q") String account);
}
