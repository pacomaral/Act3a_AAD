package com.example.paco.act3a_aad;

import android.app.Activity;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Main2Activity extends AppCompatActivity {

    private static final String PREFERENCES = "Mis preferencias";

    private TextView textoNombre, textoDNI, textoFecha, textoSexo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        //Recuperamos elementos del layout
        textoNombre = (TextView) findViewById(R.id.textoNombre);
        textoDNI = (TextView) findViewById(R.id.textoDNI);
        textoFecha = (TextView) findViewById(R.id.textoFecha);
        textoSexo = (TextView) findViewById(R.id.textoSexo);

        //Recuperamos los datos del sharedpreferences
        SharedPreferences sp = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);

        String nombre = sp.getString("nombre", "");
        String dni = sp.getString("dni", "");
        String fecha = sp.getString("fecha", "");
        String sexo = sp.getString("sexo", "");

        textoNombre.setText(nombre);
        textoDNI.setText(dni);
        textoFecha.setText(fecha);
        textoSexo.setText(sexo);
    }
}
