package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class MundoWeb extends AppCompatActivity {
    private WebView mWebView;
    Button btnAbrirWeb;

    String sdireccion;
    EditText edireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mundo_web);


        btnAbrirWeb = (Button) findViewById(R.id.btn_AbrirWeb);


        btnAbrirWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(sdireccion);

                // INI AGREGADO
                edireccion = findViewById(R.id.id_direccion);
                sdireccion = edireccion.getText().toString();
                mWebView = (WebView) findViewById(R.id.activity_main_webview);
                // Activamos jаvascript
                WebSettings webSettings = mWebView.getSettings();
                // Url que carga la app (webview)
                mWebView.loadUrl(sdireccion);
                // Forzamos el webview para que abra los enlaces internos dentro de la la APP
                mWebView.setWebViewClient(new WebViewClient());
                // Forzamos el webview para que abra los enlaces externos en el navegador
                mWebView.setWebViewClient(new MyAppWebViewClient());
               // intent.putExtra("nombre", sdireccion);
            }
        });
    }
}
