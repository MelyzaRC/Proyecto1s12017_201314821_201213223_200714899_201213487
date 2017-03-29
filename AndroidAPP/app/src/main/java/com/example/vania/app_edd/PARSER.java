package com.example.vania.app_edd;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
/**
 * Created by Vania on 24/03/2017.
 */

public class PARSER {
    ArrayList<ACTIVO> lista = new ArrayList<ACTIVO>();
    public ArrayList<ACTIVO> parsear(String json){
        try{
            String id, nombre,descripcion;


            JSONParser parser = new JSONParser();

            if(!json.isEmpty()){
                lista = new ArrayList<ACTIVO>();
                Object obj = parser.parse(json);//(String)session.getAttribute("txtjson"));
                JSONObject jsonObject =(JSONObject) obj;

                JSONArray tag = (JSONArray) jsonObject.get("catalogo");
                for(int i=0; i<tag.size();i++){
                    JSONObject tagi = (JSONObject) tag.get(i);
                    id = (String)tagi.get("id");

                    nombre = (String) tagi.get("nombre");

                    descripcion = (String) tagi.get("descripcion");

                    //System.out.println("id:"+id);
                    //System.out.println("nombre:"+nombre);
                    //System.out.println("descripcion:"+descripcion);


                    ACTIVO act = new ACTIVO(id, nombre, descripcion);
                    lista.add(act);

                }
                //System.out.println("listaid:"+lista);


            }
        } catch(Exception ex){

        }
        return lista;
    }

}


