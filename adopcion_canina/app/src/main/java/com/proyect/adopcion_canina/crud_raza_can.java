package com.proyect.adopcion_canina;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class crud_raza_can extends Fragment {
    EditText edt_nombre_raza, edt_lugar_raza, edt_descrip_raza, edt_usuAdmin_raza;
    Button btn_insertar_raza, btn_modifi_raza, btn_elimi_raza;



    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        View view = inflater.inflate ( R.layout.fragment_crud_raza_can, container, false );
        edt_nombre_raza = view.findViewById ( R.id.edt_nombre_raza_crud );
        edt_lugar_raza= view.findViewById ( R.id.edt_lugar_raza_crud );
        edt_descrip_raza= view.findViewById ( R.id.edt_descrip_raza_crud );
        edt_usuAdmin_raza= view.findViewById ( R.id.edt_usuAdmin_raza_crud );
        btn_insertar_raza= view.findViewById ( R.id.btn_insertar_raza );
        btn_modifi_raza= view.findViewById ( R.id.btn_modifi_raza );
        btn_elimi_raza=view.findViewById ( R.id.btn_eliminar_raza );
        btn_insertar_raza.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                String nombre = edt_nombre_raza.getText ().toString ();
                String lugar = edt_lugar_raza.getText ().toString ();
                String descrip = edt_descrip_raza.getText ().toString ();
                String usu = edt_usuAdmin_raza.getText ().toString ();
                item_raza insert_raza = new item_raza (  );
                insert_raza.setNombre_raza ( nombre );
                insert_raza.setLugar ( lugar );
                insert_raza.setDescripcion ( descrip );
                insert_raza.setUsu_admin ( usu );
                insert_raza.insertar_raza ( getContext () );

            }
        } );
        btn_modifi_raza.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {

            }
        } );

        btn_elimi_raza.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {

            }
        } );




        return view;
    }
}