package com.proyect.adopcion_canina.login;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.Toast;

import com.proyect.adopcion_canina.Db_usuario;

public class item_usuario implements Parcelable {

    private int telefono;
    private String direccion;
    private String usu_adop;
    private String contrasena;

    public item_usuario(){}


    protected item_usuario ( Parcel in ) {
        telefono = in.readInt ();
        direccion = in.readString ();
        usu_adop = in.readString ();
        contrasena = in.readString ();
    }

    public String getDireccion () {
        return direccion;
    }

    public String getUsu_adop () {
        return usu_adop;
    }

    public String getContrasena () {
        return contrasena;
    }

    public void setDireccion ( String direccion ) {
        this.direccion = direccion;
    }

    public void setUsu_adop ( String usu_adop ) {
        this.usu_adop = usu_adop;
    }

    public void setContrasena ( String contrasena ) {
        this.contrasena = contrasena;
    }

    public int getTelefono () {
        return telefono;
    }

    public void setTelefono ( int telefono ) {
        this.telefono = telefono;
    }

    @Override
    public String toString () {
        return "item_usuario{" +
                "telefono='" + telefono + '\''+
                ",direccion='" + direccion + '\'' +
                ", usu_adop='" + usu_adop + '\'' +
                ", contrasena='" + contrasena + '\'' +
                '}';
    }


    public  void insertar_usuario( Context context) {

        String cadena_sql = "INSERT INTO usuario (telefono, direccion, usuario, contrasena ) VALUES ('" + telefono  + "', '" + direccion + "',  '" + usu_adop +"', '"+ contrasena +"')";
        Db_usuario.consulta_sin_retorno_adopcion ( context,cadena_sql);
        Toast.makeText ( context, "usuario registrado exitosamente ", Toast.LENGTH_SHORT ).show ();
    }

    @Override
    public void writeToParcel ( Parcel dest, int flags ) {
        dest.writeInt ( telefono );
        dest.writeString ( direccion );
        dest.writeString ( usu_adop );
        dest.writeString ( contrasena );
    }

    @Override
    public int describeContents () {
        return 0;
    }

    public static final Creator<item_usuario> CREATOR = new Creator<item_usuario> () {
        @Override
        public item_usuario createFromParcel ( Parcel in ) {
            return new item_usuario ( in );
        }

        @Override
        public item_usuario[] newArray ( int size ) {
            return new item_usuario[size];
        }
    };
}
