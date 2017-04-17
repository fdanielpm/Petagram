package com.fdanielpm.petagram;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.fdanielpm.petagram.restApi.EndpointsApi;
import com.fdanielpm.petagram.restApi.adapter.RestApiAdapter;
import com.fdanielpm.petagram.restApi.model.UsuarioResponse;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NotificacionActivity extends AppCompatActivity {

    private String accountId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notificacion);
        if(  getIntent() != null && getIntent().getExtras()!=null ) {
            Bundle extras = getIntent().getExtras();
            accountId = extras.getString("instagram_account_id");
        }
    }

    public void enviarToken(View v){
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }
    private void enviarTokenRegistro(String token){

        if( accountId!=null && !accountId.isEmpty() ) {

            Log.d("TOKEN", token);
            RestApiAdapter restApiAdapter = new RestApiAdapter();
            //Gson gson = restApiAdapter.construyeDeserializadorUser();
            EndpointsApi endPoints = restApiAdapter.establecerConexionRestApiFirebase( );
            Call<UsuarioResponse> usuarioResponseCall = endPoints.registrarTokenID(token, accountId);

            usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
                @Override
                public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                    UsuarioResponse usuarioResponse = response.body();
                    String id =  usuarioResponse.getId();
                    String idDevice = usuarioResponse.getDeviceid();
                    String idUser = usuarioResponse.getUserid();

                    Log.d("ID",id);
                    Log.d("ID_DISPOSITIVO",  idDevice );
                    Log.d("ID_USER", idUser );
                    Toast.makeText(NotificacionActivity.this,"Registrado con exito en Firebase con Id: " + id ,Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onFailure(Call<UsuarioResponse> call, Throwable t) {

                }
            });

        }else{
            Toast.makeText(NotificacionActivity.this,"No ha capturado su cuenta",Toast.LENGTH_SHORT).show();
        }

    }
}
