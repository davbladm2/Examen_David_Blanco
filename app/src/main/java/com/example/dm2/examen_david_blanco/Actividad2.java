package com.example.dm2.examen_david_blanco;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.lang.reflect.Array;

public class Actividad2 extends AppCompatActivity {

    private Localidades[] datos=null;
    private TextView labelNombre,labelSuperficie,labelHabitantes,labelWeb;
    private ListView LstLocalidades;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad2);
        setTitle("Actividad 2");
        Localidades l1=new Localidades("Añana","157 hab(2015)","21,92 km2","http://www.cuadrilladeanana.es/anana");
        Localidades l2=new Localidades("Mundaka","1892 hab(2015)","4.01 km2","http://www.mundaka.org");
        Localidades l3=new Localidades("Gernika-Lumo","16763 hab(2015)","8.60 km2","http://www.gernika-lumo.net");
        Localidades l4=new Localidades("Laguardia","1520 hab(2015)","81.08 km2","http://www.ñlaguardia-alava.net");
        Localidades l5=new Localidades("Vitoria-Gasteiz","243918 hab(2015)","276.08 km2","http://www.vitoria-gasteiz.org");

         datos=new Localidades[]{l1,l2,l3,l4,l5};

        AdaptadorLocalidades adaptador=new AdaptadorLocalidades(this,datos);
        LstLocalidades= (ListView) findViewById(R.id.LstLocalidades);
        LstLocalidades.setAdapter(adaptador);

    }

   class AdaptadorLocalidades extends ArrayAdapter<Localidades>{

       public AdaptadorLocalidades(Context context,Localidades[] datos){
           super(context,R.layout.activity_actividad2,datos);
       }

       public View getView(int position, View convertView, ViewGroup parent){
           LayoutInflater inflater=LayoutInflater.from(getContext());
           View item=inflater.inflate(R.layout.activity_actividad2,null);

           labelNombre=(TextView) item.findViewById(R.id.labelNombre);
           labelNombre.setText(datos[position].getNombre());

           labelSuperficie=(TextView) item.findViewById(R.id.labelSuperficie);
           labelSuperficie.setText(datos[position].getSuperficie());

           labelHabitantes=(TextView) item.findViewById(R.id.labelHabitantes);
           labelHabitantes.setText(datos[position].getHabitantes());

           labelWeb=(TextView) item.findViewById(R.id.labelWeb);
           labelWeb.setText(datos[position].getWeb());

           return(item);
       }
    }
}
