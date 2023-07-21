package com.proyect.adopcion_canina;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Db_usuario extends SQLiteOpenHelper {

    private static final String DATABASE_CANINO = "db_can";
    private static final int DATABASE_VERSION = 1;

    public Db_usuario( @Nullable Context context, String database_canino, Object o, int i ) {
        super(context, DATABASE_CANINO, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String Crear_tabla_raza = "CREATE TABLE raza (nombre TEXT, lugar TEXT, descripcion TEXT, usuario REFERENCES usuario (usuario))";
        sqLiteDatabase.execSQL(Crear_tabla_raza);
        String Crear_tabla_can = "CREATE TABLE perro (id_can INTEGER PRIMARY KEY AUTOINCREMENT, nombre_can TEXT, edad INTEGER, descripcion TEXT, estado_adopcion TEXT, raza REFERENCES raza(nombre), usuario REFERENCES usuario (usuario))";
        sqLiteDatabase.execSQL(Crear_tabla_can);
        String Create_table_usuario = "CREATE TABLE usuario (telefono INTEGER, direccion TEXT, usuario TEXT, contrasena TEXT)";
        sqLiteDatabase.execSQL(Create_table_usuario);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        String eliminar_tablas = "DROP TABLE IF EXISTS " +DATABASE_CANINO;
        sqLiteDatabase.execSQL(eliminar_tablas);
        onCreate(sqLiteDatabase);
    }

    public static void consulta_sin_retorno_adopcion(Context context, String consulta_can) {
        Db_usuario conexion_database = new Db_usuario(context, "DATABASE_CANINO", null, 1 );
        SQLiteDatabase db = conexion_database.getWritableDatabase();
        db.execSQL(consulta_can);
        db.close();
    }

    public static String[][] consultar_con_retorno_adopcion(Context context, String consulta_can) throws Exception {
        String[][] datos_adopcion = null;
        Db_usuario conexion_database = new Db_usuario(context, "DATABASE_CANINO", null, 1 );
        SQLiteDatabase db = conexion_database.getReadableDatabase();

        try {
            Cursor cursor = db.rawQuery(consulta_can, null);
            int num_fila = cursor.getCount();
            int num_columna = cursor.getColumnCount();
            datos_adopcion = new String[num_fila][num_columna];
            int contar_filas = 0;
            while (cursor.moveToNext()) {
                for (int contar_columnas = 0; contar_columnas < num_columna; contar_columnas++) {
                    datos_adopcion[contar_filas][contar_columnas] = cursor.getString(contar_columnas);
                }
                contar_filas++;
            }
            cursor.close();
        } catch (Exception e) {

            throw e;
        } finally {
            db.close();
        }

        return datos_adopcion;
    }

    public boolean loginUsuario(String usuario, String contrasena) {
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT * FROM usuario WHERE usuario = ? AND contrasena = ?";
        String[] selectionArgs = {usuario, contrasena};

        Cursor cursor = db.rawQuery(consulta, selectionArgs);

        if (cursor.getCount() > 0) {
            // Las credenciales del usuario coinciden, el usuario existe
            cursor.close();
            db.close();
            return true;
        } else {
            // Las credenciales del usuario no coinciden o el usuario no existe
            cursor.close();
            db.close();
            return false;
        }
    }

    public List<item_can> agregar_can_recycler() {
        List<item_can> listar_can = new ArrayList<> ();
        SQLiteDatabase db = this.getReadableDatabase();
        String consulta = "SELECT * FROM perro"; // Use the correct table name
        Cursor cursor = db.rawQuery(consulta, null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") int id = cursor.getInt(cursor.getColumnIndex("id_can")); // Use the correct column names
                @SuppressLint("Range") String nombre = cursor.getString(cursor.getColumnIndex("nombre_can"));
                @SuppressLint("Range") int edad = cursor.getInt (cursor.getColumnIndex("edad"));
                @SuppressLint("Range") String descripcion = cursor.getString(cursor.getColumnIndex("descripcion"));
                @SuppressLint("Range") String estado = cursor.getString(cursor.getColumnIndex("estado_adopcion"));
                @SuppressLint("Range") String raza = cursor.getString(cursor.getColumnIndex("raza"));


                item_can can = new item_can (  );
                can.setId_can (id);
                can.setNombre_can (nombre);
                can.setEdad ( edad );
                can.setDescripcion ( descripcion );
                can.setEstado_adopcion ( estado );
                can.setRaza_can ( raza );
                listar_can.add(can);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return listar_can;
    }

}
