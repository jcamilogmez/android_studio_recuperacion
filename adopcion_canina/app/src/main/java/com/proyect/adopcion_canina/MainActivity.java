package com.proyect.adopcion_canina;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.proyect.adopcion_canina.login.inicio_sesion;
import com.proyect.adopcion_canina.login.registrar;

public class MainActivity extends AppCompatActivity {
    Button btn_registrar_usuario, btn_iniciar_sesion_usuario;



    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_main );
        btn_iniciar_sesion_usuario= findViewById ( R.id.btn_iniciar_sesion_usuario );
        btn_registrar_usuario = findViewById ( R.id.btn_registrar_usuario );
        btn_registrar_usuario.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Intent ir = new Intent (MainActivity.this, registrar.class);
                startActivity ( ir );
            }
        } );

        btn_iniciar_sesion_usuario.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                Intent ir = new Intent (MainActivity.this, inicio_sesion.class);
                startActivity ( ir );
            }
        } );
    }
}