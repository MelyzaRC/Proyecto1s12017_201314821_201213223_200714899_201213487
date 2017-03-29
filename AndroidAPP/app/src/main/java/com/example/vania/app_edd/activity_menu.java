package com.example.vania.app_edd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.webkit.WebView;

public class activity_menu extends AppCompatActivity {
    Button btn_menu_rentar;
    Button b2;
    TextView label;
    public String usuario, empresa, depto;
    public WebView webView1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        label = (TextView) findViewById(R.id.label_user);
        usuario = getIntent().getStringExtra("parametro_usuario");
        empresa = getIntent().getStringExtra("parametro_empresa");
        depto = getIntent().getStringExtra("parametro_depto");

        label.setText("Bienvenido: "+ usuario);
        btn_menu_rentar = (Button)findViewById(R.id.btn_menu_rentar);
        btn_menu_rentar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(activity_menu.this, RENTA.class);
                b.putExtra("parametro_usuario", usuario);
                b.putExtra("parametro_empresa", empresa);
                b.putExtra("parametro_depto", depto);
                startActivity(b);
            }
        });

        b2 = (Button)findViewById(R.id.btn_devolver);
        b2.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(activity_menu.this, DEVOLUCION.class);
                startActivity(b);
            }
        });
    }
}
