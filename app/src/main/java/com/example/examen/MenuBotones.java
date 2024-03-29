package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MenuBotones extends AppCompatActivity implements View.OnClickListener {
    Intent intento;
    Dialog myDialog;
    ImageView miFoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_botones);


        //POPUP
        myDialog = new Dialog(this);

        findViewById(R.id.btn_salir).setOnClickListener(this);
        findViewById(R.id.btn_camara).setOnClickListener(this);
        findViewById(R.id.btn_gps).setOnClickListener(this);
        findViewById(R.id.btn_web).setOnClickListener(this);
        findViewById(R.id.btn_acerca).setOnClickListener(this);
        findViewById(R.id.btn_calculadora).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_camara:
                intento = new Intent(this, Camara.class);
                startActivity(intento);
                break;
            case R.id.btn_gps:
                  intento = new Intent(this, Mapas.class);
                 startActivity(intento);
                break;

            case R.id.btn_acerca:

                intento = new Intent(this, AcercaDe.class);
                // startActivity(intento);
                ShowPopup();
                break;

            case R.id.btn_web:
                intento = new Intent(this, MundoWeb.class);
                startActivity(intento);
                break;

            case R.id.btn_calculadora:
                intento = new Intent(this, Calculadora.class);
                startActivity(intento);
                break;


            case R.id.btn_salir:
                //intento = new Intent(this, MuestraDatos.class);

                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                Toast.makeText(this, "Cerrando Aplicación", Toast.LENGTH_SHORT).show();
                startActivity(intent);
                break;

        }


    }


    public void ShowPopup() {
        TextView txtclose;
        Button btnFollow;
        myDialog.setContentView(R.layout.activity_acerca_de);
        txtclose = (TextView) myDialog.findViewById(R.id.txtclose);
        txtclose.setText("M");
        txtclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myDialog.dismiss();
            }
        });
        myDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        myDialog.show();
    }
}
