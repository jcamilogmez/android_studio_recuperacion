package com.proyect.adopcion_canina;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import androidx.annotation.NonNull;

public class item_can implements Parcelable {
    private  int id_can;
    private String nombre_can;
    private int edad;
    private String descripcion;
    private String estado_adopcion;
    private String raza_can;
    private String usuario_admin;

public  item_can(){}
    protected item_can ( Parcel in ) {
        id_can=in.readInt ();
        nombre_can = in.readString ();
        edad = in.readInt ();
        descripcion = in.readString ();
        estado_adopcion = in.readString ();
        raza_can = in.readString ();
        usuario_admin= in.readString ();
    }

    public String getUsuario_admin () {
        return usuario_admin;
    }

    public void setUsuario_admin ( String usuario_admin ) {
        this.usuario_admin = usuario_admin;
    }

    public int getId_can () {
        return id_can;
    }

    public String getRaza_can () {
        return raza_can;
    }

    public void setId_can ( int id_can ) {
        this.id_can = id_can;
    }

    public void setRaza_can ( String raza_can ) {
        this.raza_can = raza_can;
    }

    public String getNombre_can () {
        return nombre_can;
    }

    public int getEdad () {
        return edad;
    }

    public String getDescripcion () {
        return descripcion;
    }

    public String getEstado_adopcion () {
        return estado_adopcion;
    }

    public void setNombre_can ( String nombre_can ) {
        this.nombre_can = nombre_can;
    }

    public void setEdad ( int edad ) {
        this.edad = edad;
    }

    public void setDescripcion ( String descripcion ) {
        this.descripcion = descripcion;
    }

    public void setEstado_adopcion ( String estado_adopcion ) {
        this.estado_adopcion = estado_adopcion;
    }

    public  void insertar_can( Context context) {

        String cadena_sql = "INSERT INTO perro (id_can, nombre_can, edad, descripcion, estado_adopcion,raza, usuario) VALUES " +
                "('" + id_can  + "', '" + nombre_can + "',  '"+ edad+"', '"+ descripcion+"', '"+estado_adopcion+"', '"+raza_can+"', '"+usuario_admin+"')";
        Db_usuario.consulta_sin_retorno_adopcion ( context,cadena_sql );

    }

    public void  modificar_can( Context context){
        String cadena_sql = "UPDATE perro SET nombre_can = '"+nombre_can+"'  WHERE id_can = '"+id_can+"' ";
        Db_usuario.consulta_sin_retorno_adopcion ( context,cadena_sql );
    }

    public void eliminar_can( Context context){
        String cadena_sql = " DELETE FROM perro WHERE id_can = '"+id_can+"' ";
        Db_usuario.consulta_sin_retorno_adopcion ( context, cadena_sql );
    }
    @Override
    public String toString () {
        return "item_can{" +
                "id_can=" + id_can +
                ", nombre_can='" + nombre_can + '\'' +
                ", edad=" + edad +
                ", descripcion='" + descripcion + '\'' +
                ", estado_adopcion='" + estado_adopcion + '\'' +
                ", raza_can='" + raza_can + '\'' +
                '}';
    }

    public static final Creator<item_can> CREATOR = new Creator<item_can> () {
        @Override
        public item_can createFromParcel ( Parcel in ) {
            return new item_can ( in );
        }

        @Override
        public item_can[] newArray ( int size ) {
            return new item_can[size];
        }
    };

    @Override
    public int describeContents () {
        return 0;
    }

    @Override
    public void writeToParcel ( @NonNull Parcel parcel, int i ) {
        parcel.writeInt ( id_can );
        parcel.writeString ( nombre_can );
        parcel.writeInt ( edad );
        parcel.writeString ( descripcion );
        parcel.writeString ( estado_adopcion );
        parcel.writeString ( raza_can );
        parcel.writeString ( usuario_admin );
    }
}
