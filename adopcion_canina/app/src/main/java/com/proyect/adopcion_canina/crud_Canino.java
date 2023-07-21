package com.proyect.adopcion_canina;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;


public class crud_Canino extends Fragment {
    String[] estado= {"En adopcion","adoptado"};
    Spinner sp_estado_adop;
    EditText edt_id_can, edt_nombre_can, edt_descrip_can,  edt_edad_can, edt_raza_can, edt_usu_admin;
    Button btn_insertar_can, btn_modifi_can, btn_eliminar_can;




    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView ( LayoutInflater inflater, ViewGroup container,
                               Bundle savedInstanceState ) {
        View view = inflater.inflate ( R.layout.fragment_crud__canino, container, false );

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity (), android.R.layout.simple_spinner_item, estado);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_estado_adop= view.findViewById (  R.id.sp_estado_adopcion );
        edt_id_can = view.findViewById ( R.id.edt_crud_id_canino );
        edt_nombre_can = view.findViewById ( R.id.edt_crud_nombre_canino);
        edt_descrip_can = view.findViewById ( R.id.edt_crud_descripcion_canino2);
        edt_edad_can = view.findViewById ( R.id.edt_crud_edad_canino );
        edt_usu_admin = view.findViewById ( R.id.edt_crud_usuAdmin_canino );
        edt_raza_can = view.findViewById ( R.id.edt_crud_raza_canino );
        btn_insertar_can = view.findViewById ( R.id.btn_insertar_can );
        btn_modifi_can = view.findViewById ( R.id.btn_modifi_can );
        btn_eliminar_can= view.findViewById ( R.id.btn_eliminar_can );
        sp_estado_adop.setAdapter(adapter);
        btn_insertar_can.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {
                String id_Can = edt_id_can.getText ().toString ();
                String nombre = edt_nombre_can.getText ().toString ();
                String edad = edt_edad_can.getText ().toString ();
                String descripcion= edt_descrip_can.getText ().toString ();
                String estado = (String) sp_estado_adop.getSelectedItem ();
                String raza = edt_raza_can.getText ().toString ();
                String usuAdmin = edt_usu_admin.getText ().toString ();
                item_can insert_can = new item_can ();
                insert_can.setId_can ( Integer.parseInt (id_Can) );
                insert_can.setNombre_can ( nombre );
                insert_can.setEdad ( Integer.parseInt (edad) );
                insert_can.setDescripcion ( descripcion );
                insert_can.setEstado_adopcion ( estado );
                insert_can.setRaza_can ( raza );
                insert_can.setUsuario_admin ( usuAdmin );
                insert_can.insertar_can ( getContext () );


            }
        } );
        btn_modifi_can.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {

            }
        } );
        btn_eliminar_can.setOnClickListener ( new View.OnClickListener () {
            @Override
            public void onClick ( View view ) {

            }
        } );




        return view;
    }
}