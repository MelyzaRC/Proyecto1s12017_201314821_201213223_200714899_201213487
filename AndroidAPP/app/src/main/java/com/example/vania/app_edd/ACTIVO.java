package com.example.vania.app_edd;

/**
 * Created by Vania on 28/03/2017.
 */

public class ACTIVO {
    private String assetID;
    private String nombre;
    private String descripcion;

        public ACTIVO(String assetID, String nombre, String descripcion){
            this.assetID = assetID;
            this.nombre = nombre;
            this.descripcion = descripcion;
        }
    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
