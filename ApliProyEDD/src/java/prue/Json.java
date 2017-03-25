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
    public void metodo() throws IOException{
  JSONParser parser = new JSONParser();
          try{
              Object obj = parser.parse(new FileReader("C:/Users/Astrid Hernandez/Desktop/pr.json"));
              JSONObject jsonObject =(JSONObject) obj;
              
              String id = (String) jsonObject.get("id");
              System.out.println("id:"+id);
              
              String nombre= (String)jsonObject.get("nombre");
              System.out.println("nombre:"+nombre);
              
              
              JSONArray tag = (JSONArray) jsonObject.get("Tags");
              System.out.println("Tags");
              Iterator iterator = tag.iterator();
              while(iterator.hasNext()){
                  System.out.println(iterator.next());
                  
              }
          } catch (ParseException ex) {
                Logger.getLogger(Cargar.class.getName()).log(Level.SEVERE, null, ex);
            } catch (FileNotFoundException ex) {
            Logger.getLogger(Json.class.getName()).log(Level.SEVERE, null, ex);
        }
      
        }

    
}
