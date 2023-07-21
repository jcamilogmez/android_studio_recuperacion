package com.proyect.adopcion_canina;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.proyect.adopcion_canina.login.adactador;

import java.util.ArrayList;
import java.util.List;

public class vista_canino extends AppCompatActivity {
    RecyclerView recyclerView;
    adactador  adapter;
    List<item_can>listar_Can;
    Db_usuario db_usuario;



    @Override
    protected void onCreate ( Bundle savedInstanceState ) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.vista_can );
        db_usuario= new Db_usuario ( getApplicationContext (),"DATABASE_CANINO",null, 1 );
        recyclerView = findViewById ( R.id.recycler_can );
        recyclerView.setLayoutManager ( new LinearLayoutManager ( this ) );
        listar_Can= new ArrayList<> ();
        adapter = new adactador ( listar_Can);
        recyclerView.setAdapter ( adapter );
        listar_Can.addAll ( db_usuario.agregar_can_recycler () );

        adapter.notifyDataSetChanged ();


    }
}