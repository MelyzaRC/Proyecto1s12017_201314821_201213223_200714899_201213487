package com.example.vania.app_edd;

/**
 * Created by Vania on 28/03/2017.
 */

public class NODO_USUARIO {
    private NODO_USUARIO siguiente;
    private USUARIO dato;

    public NODO_USUARIO(USUARIO dato, NODO_USUARIO siguiente){
        this.setSiguiente(siguiente);
        this.setDato(dato);

    }

    public NODO_USUARIO getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NODO_USUARIO siguiente) {
        this.siguiente = siguiente;
    }

    public USUARIO getDato() {
        return dato;
    }

    public void setDato(USUARIO dato) {
        this.dato = dato;
    }
}
