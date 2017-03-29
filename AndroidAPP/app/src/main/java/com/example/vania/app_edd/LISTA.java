package com.example.vania.app_edd;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Vania on 21/03/2017.
 */

public class LISTA {
    private NodoTransaccion inicio;
    private NodoTransaccion fin;

    public LISTA(){
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

    public void insertar(TRANSACCION transaccion){
        NodoTransaccion actual;
        if(estaVacia()){
            actual = new NodoTransaccion(transaccion, null);
            inicio = actual;
            fin = actual;
        }else{
            actual = new NodoTransaccion(transaccion, null);
            fin.setSiguiente(actual);
            fin = actual;

        }
    }

    public void mostrar(){
        if(estaVacia()){
            //Context context;
            //context = c.getApplicationContext();
            //Toast.makeText(context.getApplicationContext(), "No hay datos para mostrar", Toast.LENGTH_SHORT).show();

        }else{
            NodoTransaccion temporal;
            temporal = inicio;
            while(temporal!= null){

            }
        }
    }



}
