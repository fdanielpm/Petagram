package com.fdanielpm.petagram;

import android.content.Context;
import android.content.Intent;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.fdanielpm.petagram.R;
import com.fdanielpm.petagram.pojo.Account;
import com.fdanielpm.petagram.restApi.ConstantesRestApi;
import com.fdanielpm.petagram.restApi.EndpointsApi;
import com.fdanielpm.petagram.restApi.adapter.RestApiAdapter;
import com.fdanielpm.petagram.restApi.model.AccountResponse;
import com.google.gson.Gson;

import java.io.FileOutputStream;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AccountActivity extends AppCompatActivity {

    private TextInputEditText textAccount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        textAccount = (TextInputEditText) findViewById(R.id.txtAccount);
    }

    public void saveAccount(View view){


        String account = textAccount.getText().toString();
        if( account !=null && !account.isEmpty() ){



            RestApiAdapter restApiAdapter = new RestApiAdapter();
            Gson gsonAccount = restApiAdapter.construyeGsonnDeserializadorAccount();
            EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonAccount);

            Call<AccountResponse> accountResponseCall = endpointsApi.getAccount( account );
            String accountId = null;
            try {
                accountResponseCall.enqueue(new Callback<AccountResponse>() {
                    @Override
                    public void onResponse(Call<AccountResponse> call, Response<AccountResponse> response) {
                        AccountResponse accountResponse = response.body();
                        Account account = accountResponse.getAccount();
                        String accountId = account.getId();
                        FileOutputStream fileOutputStream = null;
                        try{
                            fileOutputStream = openFileOutput("account.txt", Context.MODE_PRIVATE);
                            fileOutputStream.write( accountId.getBytes() );
                            Toast.makeText(AccountActivity.this,"Cuenta configurada ID=" + accountId ,Toast.LENGTH_LONG).show();
                            Intent i = new Intent(getBaseContext(), MainActivity.class);
                            i.putExtra("instagram_account_id", accountId);
                            startActivity( i );

                        }catch(Exception e){
                            Toast.makeText(AccountActivity.this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show();
                        }finally {
                            if( fileOutputStream!=null){
                                try {
                                    fileOutputStream.close();
                                }catch (Exception e){
                                    Toast.makeText(AccountActivity.this,"Ha ocurrido un error",Toast.LENGTH_SHORT).show();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<AccountResponse> call, Throwable t) {
                        System.err.println(t.getMessage());
                        t.printStackTrace();
                    }
                });
            }catch(Throwable t) {
                t.printStackTrace();
            }

        }else{
            Toast.makeText(AccountActivity.this,"No ha capturado su cuenta",Toast.LENGTH_SHORT).show();
        }



    }
}
