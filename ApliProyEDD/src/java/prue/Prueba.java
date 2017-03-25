package prue;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Astrid Hernandez
 * 
 */
import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import java.io.IOException;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

public class Prueba {
    public static OkHttpClient webClient = new OkHttpClient();
    
  
    public static String Matriz(String Usuario, String Departamento, String Empresa, String Contrasena,String Nombre){
  RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("departamento",Departamento)
                .add("empresa",Empresa)
                .add("password",Contrasena)
                .add("nombre",Nombre)
                .build();
  
try {
            URL url = new URL("http://localhost:5000/addMatrizDispersa");
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            return response_string;
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
       return null;  
}
     public static String Login(String Usuario, String Departamento, String Empresa, String Contrasena){
  RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("departamento",Departamento)
                .add("empresa",Empresa)
                .add("password",Contrasena)
                
                .build();
try {
            URL url = new URL("http://localhost:5000/Login");
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            return response_string;
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
       return null;  
}
      public static String Activo(String Usuario, String Departamento, String Empresa, String Contrasena, String nombreActivo, String descripcionActivo){
  RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("departamento",Departamento)
                .add("empresa",Empresa)
                .add("password",Contrasena)
               
                .add("nombreActivo",nombreActivo)
                .add("descripcionActivo", descripcionActivo)
                
                .build();
try {
            URL url = new URL("http://localhost:5000/addActivo");
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            return response_string;
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
       return null;  
}
           public static String Devolver(String Usuario, String Departamento, String Empresa, String Contrasena){
  RequestBody formBody = new FormEncodingBuilder()
                .add("user", Usuario)
                .add("departamento",Departamento)
                .add("empresa",Empresa)
                .add("password",Contrasena)
               
              
                
                .build();
try {
            URL url = new URL("http://localhost:5000/devolverElementos");
            Request request = new Request.Builder().url(url).post(formBody).build();
            Response response = webClient.newCall(request).execute();
            String response_string = response.body().string();
            return response_string;
        } catch (MalformedURLException ex) {
            System.out.println(ex.toString());
        } catch (IOException ex) {
            System.out.println(ex.toString());
        }
       return null;  
}
}
    

