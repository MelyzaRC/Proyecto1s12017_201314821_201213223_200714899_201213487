package com.example.vania.app_edd;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.FormEncodingBuilder;

import java.util.logging.Level;

public class MainActivity extends AppCompatActivity {

    Button b;
    Button b_prueba;
    PRUEBA p = new PRUEBA();
    LISTA_USUARIO lista = new LISTA_USUARIO();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        b = (Button)findViewById(R.id.btn_ingresar);
        //b.setOnClickListener (new View.OnClickListener()
        b.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                final String usuario = ((EditText)findViewById(R.id.txt_usuario)).getText().toString();
                final String pass = ((EditText)findViewById(R.id.txt_pass)).getText().toString();
                final String empresa = ((EditText)findViewById(R.id.txt_empresa)).getText().toString();
                final String depto = ((EditText)findViewById(R.id.txt_depto)).getText().toString();

                final RequestBody formBody = new FormEncodingBuilder()
                        .add("user", usuario)
                        .add("password", pass)
                        .add("empresa", empresa)
                        .add("departamento", depto)
                        .build();


                Thread thread = new Thread(new Runnable() {

                    @Override
                    public void run() {
                        try {

                            String resultado = p.getString(formBody);
                            if (resultado.equals("Ok")){
                                try {
                                    lista.insertar(new USUARIO(usuario, empresa, depto));
                                    Intent mostrar = new Intent(MainActivity.this, activity_menu.class);
                                    mostrar.putExtra("parametro_usuario", lista.mostrar().getUser().toString());
                                    mostrar.putExtra("parametro_empresa", lista.mostrar().getEmpresa().toString());
                                    mostrar.putExtra("parametro_depto", lista.mostrar().getDepto().toString());

                                    startActivity(mostrar);
                                }catch (Exception exception1){
                                    Toast.makeText(getApplicationContext(), "Hubo error en el IF", Toast.LENGTH_SHORT).show();
                                }
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Datos Incorrectos", Toast.LENGTH_SHORT).show();
                            }
                        } catch (Exception ex_) {
                            java.util.logging.Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex_);
                        }

                    }
                });

                thread.start();


            }
        });

        //b_prueba = (Button)findViewById(R.id.btn_prueba);


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void ingresar(View view){

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
