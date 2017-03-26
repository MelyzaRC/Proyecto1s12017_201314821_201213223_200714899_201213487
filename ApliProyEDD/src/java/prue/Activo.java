/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prue;

/**
 *
 * @author Astrid Hernandez
 */
public class Activo {
    
      String descripcion;
    String id;
        String nombre;
    String estado;



    
    
    public Activo(){
        descripcion = null;
        id= null;
        nombre = null;
        estado = null;
    }
    public Activo(String descripcion1, String id1, String nombre1,String estado1){
        
        descripcion = descripcion1;
        id = id1;
        nombre = nombre1;
        estado = estado1;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }
}