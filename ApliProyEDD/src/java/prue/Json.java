/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package prue;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Astrid Hernandez
 */
public class Json {
    public void metodo(String texto) throws IOException{
  JSONParser parser = new JSONParser();
          try{
              Object obj = parser.parse(texto);
              JSONObject jsonObject =(JSONObject) obj;
       
             /* String id = (String) jsonObject.get("id");
              System.out.println("i:"+id);
              String nombre = (String) jsonObject.get("nombre");
              System.out.println("n:"+nombre);
            */
              
            
              JSONArray tag = (JSONArray) jsonObject.get("Activos");
             for(int i=0; i<tag.size();i++){
                 JSONObject tagi = (JSONObject) tag.get(i);
                 String id = (String)tagi.get("id");
                 String nombre = (String) tagi.get("nombre");
                 
                 String descripcion = (String) tagi.get("descripcion");
                 String estado = (String) tagi.get("estado");
                 System.out.println("id:"+id);
                 System.out.println("nombre:"+nombre);
                 System.out.println("descripcion:"+descripcion);
                 System.out.println("estado:"+estado);
                 
              /* System.out.println("Activos");
              Iterator iterator = tag.iterator();
              while(iterator.hasNext()){
                  
                  
                  System.out.println(iterator.next());
                  Activo activo = new Activo();
                  System.out.println("1"+activo.nombre);
                   System.out.println("2"+activo.id);
                 */
                  
                  
              }
          } catch (Exception ex) {
               System.out.println("Error:"+ex.toString());
          }
      
        }

    
}
