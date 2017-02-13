package com.fdanielpm.petagram;

import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.fdanielpm.petagram.mail.SendMailTask;

import java.util.ArrayList;
import java.util.List;

public class MailActivity extends AppCompatActivity {

    private TextInputEditText txtNombreCompleto;
    private TextInputEditText txtEmail;
    private TextInputEditText txComentario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mail);
        txtNombreCompleto = (TextInputEditText) findViewById(R.id.txtNombreCompleto);
        txtEmail = (TextInputEditText) findViewById(R.id.txtEmail);
        txComentario = (TextInputEditText) findViewById(R.id.txComentario);
    }

    public void sendMail(View view) {
        String nombre = txtNombreCompleto.getText().toString();
        String mail = txtEmail.getText().toString();
        String comment = txComentario.getText().toString();
        List<String> recipientEmailList = new ArrayList<>();
        recipientEmailList.add( mail );
        String strEmailSubject = new StringBuilder().append("Comentario de :").append( nombre ).toString();
        String strSenderEmail = "sender@gmail.com";
        String strSenderPassword = "password";
        new SendMailTask(MailActivity.this).execute(strSenderEmail, strSenderPassword, recipientEmailList, strEmailSubject, comment);
    }
}
