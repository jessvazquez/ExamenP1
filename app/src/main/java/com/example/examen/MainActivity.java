package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    EditText ecorreo, econtrasena;
    String scorreo, scontrasena;
    Intent obj_i;

    String comparaCorreo = "David";
    String comparaContrasena = "DesMovil1p";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ecorreo = (EditText) findViewById(R.id.id_correo);
        econtrasena = (EditText) findViewById(R.id.id_contrasena);

        findViewById(R.id.btn_ingresar).setOnClickListener(this);
        findViewById(R.id.btn_limpiar).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        obj_i = new Intent(this, MenuBotones.class);
        switch (view.getId()) {
            case R.id.btn_ingresar:
                scorreo = ecorreo.getText().toString();
                scontrasena = econtrasena.getText().toString();
                if (scorreo.equals(comparaCorreo) && scontrasena.equals(comparaContrasena)) {
                    Toast.makeText(this, "Iniciando sesion...", Toast.LENGTH_SHORT).show();
                    startActivity(obj_i);

                } else {
                    Toast.makeText(this, "Correo o contrasena invalidos...", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }



}
