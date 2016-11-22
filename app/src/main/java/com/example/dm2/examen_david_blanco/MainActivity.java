package com.example.dm2.examen_david_blanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pulsar(View v) {
        Intent intent;

        if (v.getId() == R.id.ButtonActividad1){
            intent=new Intent(MainActivity.this,Actividad1.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ButtonActividad2){
            intent=new Intent(MainActivity.this,Actividad2.class);
            startActivity(intent);
        }
        if (v.getId() == R.id.ButtonActividad3){
            Toast toast =Toast.makeText(getApplicationContext(),"Actividad no implementada", Toast.LENGTH_SHORT);
            toast.show();
        }
        if(v.getId()==R.id.ButtonSalir){
            finish();
        }
    }
}
