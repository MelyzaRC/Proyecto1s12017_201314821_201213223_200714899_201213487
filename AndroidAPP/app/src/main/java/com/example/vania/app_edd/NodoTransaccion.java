package com.example.vania.app_edd;

/**
 * Created by Vania on 21/03/2017.
 */

public class NodoTransaccion {
    private NodoTransaccion siguiente;
    private TRANSACCION dato;

    public NodoTransaccion(TRANSACCION dato, NodoTransaccion siguiente){
        this.setSiguiente(siguiente);
        this.setDato(dato);

    }

    public NodoTransaccion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTransaccion siguiente) {
        this.siguiente = siguiente;
    }

    public TRANSACCION getDato() {
        return dato;
    }

    public void setDato(TRANSACCION dato) {
        this.dato = dato;
    }
}
