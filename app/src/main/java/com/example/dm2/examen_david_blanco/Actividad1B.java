package com.example.dm2.examen_david_blanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class Actividad1B extends AppCompatActivity {

    private TextView textViewNombreSele,textViewProvinciaSele,textViewSexoSele,textViewConocimientosSele;
    private ArrayList<String> lista;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1_b);
        setTitle("Actividad 1");

        Bundle extras=getIntent().getExtras();
        String nombre=extras.getString("nombre");
        String provincia=extras.getString("provincia");
        String sexo=extras.getString("sexo");
        lista=extras.getStringArrayList("conocimientos");

        textViewNombreSele=(TextView) findViewById(R.id.textViewNombreSele);
        textViewProvinciaSele=(TextView) findViewById(R.id.textViewProvinciaSele);
        textViewSexoSele=(TextView) findViewById(R.id.textViewSexoSele);
        textViewConocimientosSele=(TextView)findViewById(R.id.textViewConocimientosSele);

        textViewNombreSele.setText("Nombre: "+nombre);
        textViewProvinciaSele.setText("Provincia: "+provincia);
        textViewSexoSele.setText("Sexo: "+sexo);
        textViewConocimientosSele.setText("Conocimientos: ");
        for (String con:lista) {
            textViewConocimientosSele.setText( textViewConocimientosSele.getText()+con+" ,");
        }

    }
    public void comprobar(View v) {
        Intent intent=new Intent();
        if (v.getId() == R.id.buttonAceptar){
            setResult(RESULT_OK,intent);
        }

        if (v.getId() == R.id.buttonCancelar){
            setResult(RESULT_CANCELED,intent);
        }
        finish();
    }
}
