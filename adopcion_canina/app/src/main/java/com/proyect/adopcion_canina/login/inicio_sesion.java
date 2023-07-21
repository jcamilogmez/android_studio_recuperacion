package com.proyect.adopcion_canina.login;

import static com.proyect.adopcion_canina.Db_usuario.consultar_con_retorno_adopcion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.proyect.adopcion_canina.Db_usuario;
import com.proyect.adopcion_canina.Menu;
import com.proyect.adopcion_canina.R;

public class inicio_sesion extends AppCompatActivity {
    EditText edt_correo_ini, edt_contrasena_ini;
    Button btn_iniciar_sesion;
    Db_usuario db_usuario;

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_inicio_sesion );
        db_usuario = new Db_usuario(getApplicationContext(), "DATABASE_CANINO", null, 1);

        edt_correo_ini = findViewById ( R.id.edt_usuario_ini );
        edt_contrasena_ini = findViewById ( R.id.edt_contrasena_ini );
        btn_iniciar_sesion = findViewById ( R.id.btn_iniciar_sesion_usu );
        btn_iniciar_sesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Db_usuario db_usuario = new Db_usuario(getApplicationContext(), "DATABASE_CANINO", null, 1);
                String correo_usu = edt_correo_ini.getText().toString();
                String contrasena_usu = edt_contrasena_ini.getText().toString();

                item_usuario inicio_ses = new item_usuario();
                inicio_ses.setUsu_adop(correo_usu);
                inicio_ses.setContrasena(contrasena_usu);

                boolean loggedIn = db_usuario.loginUsuario(correo_usu, contrasena_usu);

                if (loggedIn) {
                    Intent ir = new Intent (inicio_sesion.this, Menu.class);
                    startActivity ( ir );
                    Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();

                } else {

                    Toast.makeText(getApplicationContext(), "Nombre de usuario o contraseña inválidos", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


}