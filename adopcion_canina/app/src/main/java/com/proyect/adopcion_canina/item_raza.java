package com.proyect.adopcion_canina;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

public class item_raza implements Parcelable {
    private String nombre_raza;
    private String lugar;
    private String descripcion;
    private String usu_admin;

  public  item_raza(){}
    protected item_raza ( Parcel in ) {
        nombre_raza = in.readString ();
        lugar = in.readString ();
        descripcion = in.readString ();
        usu_admin= in.readString ();
    }

    public String getUsu_admin () {
        return usu_admin;
    }

    public void setUsu_admin ( String usu_admin ) {
        this.usu_admin = usu_admin;
    }

    public String getNombre_raza () {
        return nombre_raza;
    }

    public String getLugar () {
        return lugar;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public void setNombre_raza ( String nombre_raza ) {
        this.nombre_raza = nombre_raza;
    }

    public void setLugar ( String lugar ) {
        this.lugar = lugar;
    }

    public void setDescripcion ( String descripcion ) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString () {
        return "item_raza{" +
                "nombre_raza='" + nombre_raza + '\'' +
                ", lugar='" + lugar + '\'' +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }

    public  void insertar_raza( Context context) {

        String cadena_sql = "INSERT INTO raza (nombre, lugar, descripcion , usuario) VALUES " +
                "('" + nombre_raza  + "', '" + lugar + "',  '"+ descripcion+"', '"+ usu_admin+"')";
        Db_usuario.consulta_sin_retorno_adopcion ( context,cadena_sql );
        Toast.makeText ( context, "raza insertada con exito", Toast.LENGTH_SHORT ).show ();

    }

    public void  modificar_can( Context context){
        String cadena_sql = "UPDATE raza SET nombre = '"+nombre_raza+"'  WHERE usuario = '"+usu_admin+"' ";
        Db_usuario.consulta_sin_retorno_adopcion ( context,cadena_sql );
    }

    public void eliminar_can( Context context){
        String cadena_sql = " DELETE FROM raza WHERE usuario = '"+usu_admin+"' ";
        Db_usuario.consulta_sin_retorno_adopcion ( context, cadena_sql );
    }

    @Override
    public void writeToParcel ( Parcel dest, int flags ) {
        dest.writeString ( nombre_raza );
        dest.writeString ( lugar );
        dest.writeString ( descripcion );
        dest.writeString ( usu_admin );
    }

    @Override
    public int describeContents () {
        return 0;
    }

    public static final Creator<item_raza> CREATOR = new Creator<item_raza> () {
        @Override
        public item_raza createFromParcel ( Parcel in ) {
            return new item_raza ( in );
        }

        @Override
        public item_raza[] newArray ( int size ) {
            return new item_raza[size];
        }
    };
}
