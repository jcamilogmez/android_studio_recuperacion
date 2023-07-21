package com.proyect.adopcion_canina.login;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.proyect.adopcion_canina.R;

public class registrar extends AppCompatActivity {
    EditText edt_telefono_usu, edt_direccion_usu, edt_usuario, edt_contraseña_usu;
    Button btn_registrar_usu;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_registrar );
        edt_telefono_usu = findViewById ( R.id.edt_telefono_usu_register );
        edt_direccion_usu = findViewById ( R.id.edt_direccion_usu_register );
        edt_usuario = findViewById ( R.id.edt_correo_usu_register );
        edt_contraseña_usu = findViewById ( R.id.edt_contra_usu_register );
        btn_registrar_usu = findViewById ( R.id.btn_registrar_usu );
        btn_registrar_usu.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                String telefono_usu = edt_telefono_usu.getText ().toString ();
                String direccion_usu = edt_direccion_usu.getText ().toString ();
                String usuario = edt_usuario.getText ().toString ();
                String contrasena_usu = edt_contraseña_usu.getText ().toString ();
                item_usuario registrar_usu = new item_usuario (  );
                registrar_usu.setTelefono ( Integer.parseInt (telefono_usu) );
                registrar_usu.setDireccion ( direccion_usu );
                registrar_usu.setUsu_adop ( usuario );
                registrar_usu.setContrasena ( contrasena_usu );
                registrar_usu.insertar_usuario ( getApplicationContext ());

            }
        } );

    }



}