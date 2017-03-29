package com.example.vania.app_edd;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.lang.Object;
import java.net.URLConnection;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;
import com.squareup.okhttp.FormEncodingBuilder;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;

import javax.net.ssl.HttpsURLConnection;

import static java.net.Proxy.Type.HTTP;


/**
 * Created by Vania on 24/03/2017.
 */


//AQUÍ ESTÁN TODAS LAS PETICIONES A PYTHON Y A C#
public class PRUEBA {
    public static OkHttpClient webClient = new OkHttpClient();
    public String string_temporal;
    public String json_temporal;
    public void prueba_conexion(){


    }
    public String getString(final RequestBody  formBody)  {

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    URL url = new URL("http://192.168.43.223:5000/Login");
                    Request request = new Request.Builder().url(url).post(formBody).build();
                    Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
                    String response_string = response.body().string();//y este seria el string de las respuesta
                    string_temporal = response_string;
                }catch (MalformedURLException ex) {
                    java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
                }  catch (Exception ex) {
                    java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
                }

            }

        });

        thread.start();

        return string_temporal;
    }

    public String getJson(final RequestBody  formBody)  {

        try {
                    /*
                    URL url = new URL("http://192.168.43.223:5000/Login");
                    Request request = new Request.Builder().url(url).post(formBody).build();
                    Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
                    String response_string = response.body().string();//y este seria el string de las respuesta
                    string_temporal = response_string;
                    */
            URL url = new URL("http://192.168.43.223:5000/catalogo");
            Request request = new Request.Builder().url(url).post(formBody).build();

            Response response = webClient.newCall(request).execute();//Aqui obtiene la respuesta en dado caso si hayas pues un return en python
            synchronized (response) {
                json_temporal = response.body().string();//y este seria el string de las respuesta
                return json_temporal;
            }
            //json_temporal = r_string;
        }catch (MalformedURLException ex) {
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
        }  catch (Exception ex) {
            java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
        }

        return json_temporal;
    }


    public void conectar() throws IOException {


        final URL u = new URL("http://192.168.43.81/webapi/api/ArbolB/insertar?assetID=activo1&departamento=informatica&empresa=cvt&userID=ejc&diasRentados=5");
        HttpURLConnection urlConnection = (HttpURLConnection) u.openConnection();
        System.out.print(urlConnection.getContent());
        //192.168.43.81/webapi/api/ArbolB/insertar?assetID=activo1&departamento=informatica&empresa=cvt&userID=ejc&diasRentados=5
    }
    public void conectar2(final String assetID, final String departamento, final String empresa, final String userID, final String diasRentados){

        Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    URL post = new URL ("http://192.168.43.81/webapi/api/ArbolB/insertar?assetID="+assetID+"&departamento="+departamento+"&empresa="+empresa+"&userID="+userID+"&diasRentados="+diasRentados);
                    URLConnection con = post.openConnection();
                    con.connect();
                    String res = con.getContent().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();

      /*  Thread thread = new Thread(new Runnable() {

            @Override
            public void run() {
                try  {
                    URL post = new URL ("http://192.168.43.81/webapi/api/ArbolB/insertar?assetID=activo1&departamento=informatica&empresa=cvt&userID=ejc&diasRentados=5");
                    URLConnection con = post.openConnection();
                    con.connect();
                    String res = con.getContent().toString();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        thread.start();*/
        /*try{
            URL post = new URL ("http://192.168.43.81/webapi/api/ArbolB/insertar?assetID=activo1&departamento=informatica&empresa=cvt&userID=ejc&diasRentados=5");
            URLConnection con = post.openConnection();
            con.connect();
            String res = con.getContent().toString();
        }
        catch (Exception e) {
            e.printStackTrace();
        }*/
    }



}
