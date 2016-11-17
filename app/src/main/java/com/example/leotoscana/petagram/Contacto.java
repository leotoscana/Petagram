package com.example.leotoscana.petagram;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import javax.mail.internet.MimeMessage;

public class Contacto extends AppCompatActivity {

    private Button boton;
    private EditText subjeto;
    private EditText correo;
    private EditText mensaje;
    private EditText correoP;
    private EditText contraseña;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        boton      = (Button) findViewById(R.id.boton);
        subjeto    = (EditText) findViewById(R.id.subjetoContacto);
        correo     = (EditText) findViewById(R.id.emailContacto);
        mensaje    = (EditText) findViewById(R.id.mensajeContacto);
        correoP    = (EditText) findViewById(R.id.emailPersonal);
        contraseña = (EditText) findViewById(R.id.contraseñaPersonal);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviar();
            }
        });}

        public void enviar(){
            final String email    = correo.getText().toString().trim();
            final String subject  = subjeto.getText().toString().trim();
            final String message  = mensaje.getText().toString().trim();
            final String emailP   = correoP.getText().toString().trim();
            final String password = contraseña.getText().toString().trim();

            SendMail sm = new SendMail(this, email, subject, message, emailP, password);

            //Executing sendmail to send email
            sm.execute();
    }

}
