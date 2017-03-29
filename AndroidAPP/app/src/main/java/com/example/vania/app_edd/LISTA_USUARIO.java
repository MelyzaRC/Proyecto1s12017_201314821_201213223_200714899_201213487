package com.example.vania.app_edd;

/**
 * Created by Vania on 21/03/2017.
 */

public class LISTA_USUARIO {

    private NODO_USUARIO inicio;
    private NODO_USUARIO fin;

    public LISTA_USUARIO(){
        inicio = null;
        fin = null;
    }
    public boolean estaVacia(){
        if(inicio == null){
            return true;
        }
        else{
            return false;
        }

    }

    public void insertar(USUARIO usuario){
        NODO_USUARIO actual;
        if(estaVacia()){
            actual = new NODO_USUARIO(usuario, null);
            inicio = actual;
            fin = actual;
        }else{
            actual = new NODO_USUARIO(usuario, null);
            fin.setSiguiente(actual);
            fin = actual;

        }
    }

    public USUARIO mostrar(){
        USUARIO u = new USUARIO(null, null, null);
        if(estaVacia()){
            //Context context;
            //context = c.getApplicationContext();
            //Toast.makeText(context.getApplicationContext(), "No hay datos para mostrar", Toast.LENGTH_SHORT).show();

        }else{
            NODO_USUARIO temporal;
            temporal = inicio;
            while(temporal!= null){
                u = temporal.getDato();
                temporal = temporal.getSiguiente();

            }
        }
        return u;
    }
}
