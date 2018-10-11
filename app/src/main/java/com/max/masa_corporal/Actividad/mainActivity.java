package com.max.masa_corporal.Actividad;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;
import com.max.masa_corporal.R;

public class mainActivity extends AppCompatActivity {
    private EditText edtPeso,edtAltura,edtEdad;
    private TextView txtResulPeso,txtResulAltura,txtResulGenero,txtResulEdad;
    private Spinner spinGenero;
    private Button btoCalcular;
    private Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_main);



        edtPeso=findViewById(R.id.edt_Peso_Id);
        edtAltura=findViewById(R.id.edt_Altura_Id);
        edtEdad=findViewById(R.id.edt_Edad_Id);
        btoCalcular=findViewById(R.id.Btn_Calcular_Id);
        spinGenero=findViewById(R.id.Spin_Genero_Id);
        txtResulPeso=findViewById(R.id.txtResulPeso);
        txtResulAltura=findViewById(R.id.txtResulAltura);
        txtResulGenero=findViewById(R.id.txtResulGenero);
        txtResulEdad=findViewById(R.id.txtResulEdad);


        SharedPreferences preferences=getSharedPreferences("valores",Context.MODE_PRIVATE);
        txtResulPeso.setText(preferences.getString("peso"," "));
        edtPeso.setText(preferences.getString("peso"," "));
        txtResulAltura.setText(preferences.getString("altura"," "));
        edtAltura.setText(preferences.getString("altura"," "));

        txtResulGenero.setText(String.valueOf(preferences.getLong("genero",0l)));

        Long valorCombo = preferences.getLong("genero",0l);

        spinGenero.setSelection( valorCombo.intValue() );
        txtResulEdad.setText(preferences.getString("edad"," "));
        edtEdad.setText(preferences.getString("edad"," "));

        //TOOLBAR
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Masa Corporal");    //titulo en la barra de accion
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);   //logo
    }
    public void onClick(View view){

        //Shared
        SharedPreferences preferences=getSharedPreferences("valores", Context.MODE_PRIVATE);

        String peso=edtPeso.getText().toString();
        String altura=edtAltura.getText().toString();
        Long genero= spinGenero.getSelectedItemId();
        String edad=edtEdad.getText().toString();


        SharedPreferences.Editor editor=preferences.edit();

        editor.putString("peso",peso);
        editor.putString("altura",altura);
        editor.putLong("genero",genero);
        editor.putString("edad",edad);
        editor.commit();

        txtResulPeso.setText(peso+" Kg ");
        txtResulAltura.setText(altura+" Cm ");
        txtResulGenero.setText(String.valueOf(genero));
        txtResulEdad.setText(edad+" Edad");
    }

    //<<<Menu 3 puntos>>>
    @Override
    public boolean onCreateOptionsMenu(Menu me) {
        getMenuInflater().inflate(R.menu.menu,me);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:
                onBackPressed();
                break;}
        switch (item.getItemId()){
            case R.id.agregar_id:
                break;}
        switch (item.getItemId()){
            case R.id.salir_id:
                break;
        }
        return true;
    }
    public class jsonMasa extends AsyncTask<String,Void,String>{

        @Override
        protected String doInBackground(String... strings) {
            return null;
        }
    }
}
