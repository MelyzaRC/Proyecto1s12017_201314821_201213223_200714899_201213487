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
              
            
              
              
              JSONArray tag = (JSONArray) jsonObject.get("Activos");
              System.out.println("Activos");
              Iterator iterator = tag.iterator();
              while(iterator.hasNext()){
                  System.out.println(iterator.next());
                  Activo activo =  (Activo) iterator.next();
                  System.out.println("1"+activo.nombre);
                   System.out.println("2"+activo.id);
                  
                  
              }
          } catch (Exception ex) {
               System.out.println("Error:"+ex.toString());
          }
      
        }

    
}
