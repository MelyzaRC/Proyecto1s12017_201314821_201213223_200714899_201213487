package com.example.vania.app_edd;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class DEVOLUCION extends AppCompatActivity {
    Button b_regresar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_devolucion);
        b_regresar = (Button)findViewById(R.id.btn_regresar);
        b_regresar.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent b = new Intent(DEVOLUCION.this, activity_menu.class);
                startActivity(b);
            }
        });
    }
}
