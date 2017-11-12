package com.example.paco.act3a_aad;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

public class MainActivity extends AppCompatActivity {


    private EditText nombre, dni, fecha;
    private RadioButton opcionHombre, opcionMujer;
    private Button botonContinuar;
    private static final String PREFERENCES = "Mis preferencias";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recuperamos los elementos del layout
        nombre = (EditText)findViewById(R.id.cajaNombre);
        dni = (EditText)findViewById(R.id.cajaDNI);
        fecha = (EditText)findViewById(R.id.cajaFecha);
        opcionHombre = (RadioButton)findViewById(R.id.opcionHombre);
        opcionMujer = (RadioButton)findViewById(R.id.opcionMujer);
        botonContinuar = (Button) findViewById(R.id.botonContinuar);


        //Añadimos un onClick listener al boton
        botonContinuar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Creamos el intent que lanzará posteriormente la segunda activity
                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);

                //Guardamos los datos necesarios mediante sharedpreferences
                SharedPreferences sp = getSharedPreferences(PREFERENCES, Activity.MODE_PRIVATE);
                SharedPreferences.Editor editor = sp.edit();

                //Guardamos los datos introducidos por el usuario
                editor.putString("nombre", String.valueOf(nombre.getText()));
                editor.putString("dni", String.valueOf(dni.getText()));
                editor.putString("fecha", String.valueOf(fecha.getText()));

                //Dependiendo de lo que el usuario haya elegido se guarda una cosa u otra
                if(opcionHombre.isChecked()){
                    editor.putString("sexo", "Hombre");
                }
                else if(opcionMujer.isChecked()){
                    editor.putString("sexo", "Mujer");
                }

                editor.commit();

                //Lanzamos la actividad
                startActivity(intent);
            }
        });
    }
}
