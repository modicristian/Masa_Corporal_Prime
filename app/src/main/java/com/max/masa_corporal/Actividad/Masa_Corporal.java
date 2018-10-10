package com.max.masa_corporal.Actividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;

import com.max.masa_corporal.Listener.ListenerCalcular;
import com.max.masa_corporal.R;

public class Masa_Corporal extends AppCompatActivity {
    private EditText edtPeso,edtAltura,edtEdad;
    private Spinner spinGenero;
    private Button btoCalcular;
    private Toolbar toolbar;

    public EditText getEdtPeso() {
        return edtPeso;
    }

    public EditText getEdtAltura() {
        return edtAltura;
    }

    public EditText getEdtEdad() {
        return edtEdad;
    }

    public Spinner getSpinGenero() {
        return spinGenero;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_a);

        edtPeso=findViewById(R.id.edt_Peso_Id);
        edtAltura=findViewById(R.id.edt_Altura_Id);
        edtEdad=findViewById(R.id.edt_Edad_Id);
        btoCalcular=findViewById(R.id.Btn_Calcular_Id);
        spinGenero=findViewById(R.id.Spin_Genero_Id);



        //Listener
        ListenerCalcular listenerCalcular=new ListenerCalcular(this);
        //seteo
        btoCalcular.setOnClickListener(listenerCalcular);
        //TOOLBAR
        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("Masa Corporal");    //titulo en la barra de accion
        getSupportActionBar().setLogo(R.drawable.ic_launcher_foreground);   //logo
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
}
