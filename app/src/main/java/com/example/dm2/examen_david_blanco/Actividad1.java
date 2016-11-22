package com.example.dm2.examen_david_blanco;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class Actividad1 extends AppCompatActivity {

    private Spinner spinnerProvicias;
    private EditText editTextNum2,editTextNum1;
    private EditText editTextNombre, editTextResultado;
    private int num1,num2,result,res,numVeces=0;
    private RadioGroup radioGroup;
    private RadioButton radioMasculino,radioFemenino;
    private ArrayList<String> lista=null;
    private CheckBox checkPHP,checkJava,checkHtml,checkCSS;
    private TextView textViewNumCandidatos;
    private Button buttonEvaluar,buttonSalir;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad1);
        setTitle("Actividad 1");

        spinnerProvicias=(Spinner) findViewById(R.id.spinnerProvicias);
        final String[] arrProv=new String[]{"Álava","Bizkaia","Guipuzkoa"};
        ArrayAdapter<String> adapatador=new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,arrProv);
        adapatador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerProvicias.setAdapter(adapatador);

        editTextNum1=(EditText)findViewById(R.id.editTextNum1);
        editTextNum2=(EditText)findViewById(R.id.editTextNum2);
        aleatorio();

        editTextNombre =(EditText) findViewById(R.id.editTextNombre);
        editTextResultado=(EditText) findViewById(R.id.editTextResultado);

        radioGroup=(RadioGroup) findViewById(R.id.radioGroup);
        radioMasculino=(RadioButton) findViewById(R.id.radioMasculino);
        radioFemenino=(RadioButton) findViewById(R.id.radioFemenino);

        checkCSS=(CheckBox) findViewById(R.id.checkPHP);
        checkJava=(CheckBox) findViewById(R.id.checkJava);
        checkHtml=(CheckBox) findViewById(R.id.checkHtml);
        checkCSS=(CheckBox) findViewById(R.id.checkCSS);

        textViewNumCandidatos=(TextView) findViewById(R.id.textViewNumCandidatos);

        buttonEvaluar=(Button) findViewById(R.id.buttonEvaluar);
        buttonSalir=(Button) findViewById(R.id.buttonSalir);
    }

    public void aleatorio(){
        num1=(int) (Math.random()*100+1);
        num2=(int) (Math.random()*100+1);
        res=num1+num2;
        editTextNum1.setText(Integer.toString(num1));
        editTextNum2.setText(Integer.toString(num2));
    }

    public void evaluar(View v) {
        Intent intent;
        //Comprobar boton evaluar
        if (v.getId() == R.id.buttonEvaluar){
            //Comprobar número de candidatos
            if(Integer.parseInt(textViewNumCandidatos.getText().toString())!=4){
                //Comprobar el numero de veces
                if(numVeces!=3){
                    if(editTextNombre.getText().toString().equals("")){
                        Toast toast =Toast.makeText(getApplicationContext(),"Rellenar nombre", Toast.LENGTH_SHORT);
                        toast.show();
                    }else{
                        result=Integer.parseInt(editTextResultado.getText().toString());
                        if(result==res){
                            intent=new Intent(Actividad1.this,Actividad1B.class);
                            intent.putExtra("nombre",editTextNombre.getText().toString());
                            intent.putExtra("provincia",spinnerProvicias.getSelectedItem().toString());
                            int idSeleccionado=radioGroup.getCheckedRadioButtonId();
                            if(idSeleccionado==radioMasculino.getId()){
                                intent.putExtra("sexo",radioMasculino.getText().toString());
                            }
                            if(idSeleccionado==radioFemenino.getId()){
                                intent.putExtra("sexo",radioFemenino.getText().toString());
                            }

                            lista=new ArrayList<>();
                            if(checkCSS.isChecked()){
                                lista.add(checkCSS.getText().toString());
                            }
                            if(checkJava.isChecked()){
                                lista.add(checkJava.getText().toString());
                            }
                            if(checkHtml.isChecked()){
                                lista.add(checkHtml.getText().toString());
                            }
                            if(checkCSS.isChecked()){
                                lista.add(checkCSS.getText().toString());
                            }
                            intent.putExtra("conocimientos",lista);

                            startActivityForResult(intent,1234);
                        }else{
                            numVeces++;
                            Toast toast =Toast.makeText(getApplicationContext(),"Resultado de la operación erroneo", Toast.LENGTH_SHORT);
                            toast.show();
                        }
                    }
                }else{
                    Toast toast =Toast.makeText(getApplicationContext(),"Ya no hay más intentos", Toast.LENGTH_SHORT);
                    toast.show();
                    intent=new Intent(Actividad1.this,MainActivity.class);
                    startActivity(intent);
                }
            }else{
                buttonEvaluar.setVisibility(View.INVISIBLE);
                buttonSalir.setVisibility(View.VISIBLE);
            }

        }

        //Comprobar boton evaluar
        if (v.getId() == R.id.buttonSalir){
            finish();
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        if(requestCode==1234 && resultCode==RESULT_OK){
            int num =Integer.parseInt(textViewNumCandidatos.getText().toString());
            num+=1;
            textViewNumCandidatos.setText(Integer.toString(num));
        }
    }
}
