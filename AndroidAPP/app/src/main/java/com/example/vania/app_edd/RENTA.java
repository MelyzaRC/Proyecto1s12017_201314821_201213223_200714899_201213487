package com.example.vania.app_edd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.okhttp.FormEncodingBuilder;
import com.squareup.okhttp.RequestBody;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.logging.Level;

public class RENTA extends AppCompatActivity {
    Button b_regresar2;
    Button bbb;
    Spinner s;
    TextView prueba_json;
    PRUEBA p = new PRUEBA();
    String label_prueba;
    static String catalogo;
    String assetID, nombre, descripcion, estado;
    String cadena_json;
    TextView lbl_nombre;
    TextView lbl_descripcion;
    JSONObject json;
    PARSER parser = new PARSER();
    EditText txt_diasR;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rent);
        final RequestBody formBody = new FormEncodingBuilder()
                .add("user", "sdfs")
                .add("password", "sdfs")
                .add("empresa", "sdfs")
                .add("departamento", "sdfs")
                .build();
        //Toast.makeText(getApplicationContext(), p.getJson(formBody).toString(), Toast.LENGTH_LONG).show();
        try{

            //prueba_json.setText(cadena_prueba);
            //Toast.makeText(getApplicationContext(), cadena_prueba, Toast.LENGTH_LONG).show();
            Thread thread = new Thread(new Runnable() {

                @Override
                public void run() {
                    try {

                        prueba_json =(TextView) findViewById(R.id.label_descripcion);
                        String cadena_prueba1 = p.getJson(formBody);
                        Log.d("prueba", cadena_prueba1);
                        //String cadena_prueba = p.getJson(formBody);
                        String cadena_prueba2 = p.json_temporal;

                        //Toast.makeText(getApplicationContext(), cadena_prueba2.toString(), Toast.LENGTH_LONG).show();
                        RENTA.catalogo = cadena_prueba2;
                    }catch (Exception ex) {
                        java.util.logging.Logger.getLogger(PRUEBA.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }

            });
            thread.sleep(2000);
            thread.start();
            int i=0;
        }catch (Exception exx){
            Toast.makeText(getApplicationContext(), exx.toString(), Toast.LENGTH_LONG).show();
        }
        //Toast.makeText(getApplicationContext(), RENTA.catalogo, Toast.LENGTH_LONG).show();
        try {
            Thread.sleep(2000);
        } catch (Exception ex){

        }
        //prueba_json.setText(RENTA.catalogo);
        lbl_nombre = (TextView) findViewById(R.id.label_nombre);
        lbl_descripcion = (TextView) findViewById(R.id.label_descripcion);
         cadena_json = RENTA.catalogo.replace("\n","");
        ArrayList<ACTIVO> listaact = parser.parsear(cadena_json);

        int cantidad = listaact.size() ;

        String[] array_id = new String[cantidad];
        for(int i=0; i<cantidad;i++){
            array_id[i] = listaact.get(i).getAssetID();

        }
        s = (Spinner) findViewById(R.id.comboAssetID);
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, array_id);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        s.setAdapter(dataAdapter);




        /*for(int i=0; i<cantidad;i++){
            lbl_nombre.setText(listaact.get(i).getNombre());
            lbl_descripcion.setText(listaact.get(i).getDescripcion());

        }*/

        bbb = (Button)findViewById(R.id.btn_rentar_activo);
        bbb.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Spinner spinner1 =(Spinner) findViewById(R.id.comboAssetID);
                String assetID = spinner1.getSelectedItem().toString();

                //Spinner spinner2 =(Spinner) findViewById(R.id.comboDias);
                //String diasRentados = spinner2.getSelectedItem().toString();
                txt_diasR = (EditText) findViewById(R.id.txt_dias);
                String diasRentados = txt_diasR.getText().toString();

                p.conectar2(assetID, getIntent().getStringExtra("parametro_depto"), getIntent().getStringExtra("parametro_empresa"), getIntent().getStringExtra("parametro_usuario"), diasRentados);

            }
        });



        b_regresar2 = (Button)findViewById(R.id.btn_regresarR);
        b_regresar2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(RENTA.this, activity_menu.class);
                startActivity(b);
            }
        });
    }


}
