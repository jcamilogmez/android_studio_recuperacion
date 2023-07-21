package com.proyect.adopcion_canina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_menu );
    }
    public void ir_vista_can ( View view ){
        Intent ir= new Intent (Menu.this, vista_canino.class);
        startActivity ( ir );

    }

    public void crud_can(View view){

        Fragment frag = new crud_Canino ();
        FragmentManager fram= getSupportFragmentManager ();
        FragmentTransaction frat = fram.beginTransaction ();
        frat.replace ( R.id.conte_can , frag );
        frat.commit ();
    }

    public void crud_raza(View view){

        Fragment frag = new crud_raza_can ();
        FragmentManager fram= getSupportFragmentManager ();
        FragmentTransaction frat = fram.beginTransaction ();
        frat.replace ( R.id.conte_can , frag );
        frat.commit ();
    }
}