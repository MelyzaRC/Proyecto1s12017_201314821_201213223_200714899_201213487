package com.example.vania.app_edd;

/**
 * Created by Vania on 23/03/2017.
 */

public class USUARIO {
    public String usuario;


    public String empresa;
    public String depto;

    public USUARIO(String usuario, String empresa, String depto) {
        this.usuario = usuario;
        this.empresa = empresa;
        this.depto = depto;
    }


    public String getUser() {
        return usuario;
    }

    public void setUser(String user) {
        this.usuario = user;
    }




    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDepto() {
        return depto;
    }

    public void setDepto(String depto) {
        this.depto = depto;
    }
}
