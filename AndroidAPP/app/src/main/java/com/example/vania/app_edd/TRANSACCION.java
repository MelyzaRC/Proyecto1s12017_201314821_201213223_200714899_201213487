package com.example.vania.app_edd;

import java.util.Date;

/**
 * Created by Vania on 23/03/2017.
 */

public class TRANSACCION {
    private String transaccionID;
    private String activoID;
    private String usuarioID;
    private String empresa;
    private String departamento;
    private String fecha;
    private int dias;


    public String getTransaccionID() {
        return transaccionID;
    }

    public void setTransaccionID(String transaccionID) {
        this.transaccionID = transaccionID;
    }

    public String getActivoID() {
        return activoID;
    }

    public void setActivoID(String activoID) {
        this.activoID = activoID;
    }

    public String getUsuarioID() {
        return usuarioID;
    }

    public void setUsuarioID(String usuarioID) {
        this.usuarioID = usuarioID;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }


    public int getDias() {
        return dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }


}
