package com.max.masa_corporal.Actividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.max.masa_corporal.Listener.ListenerCalcular;
import com.max.masa_corporal.R;

public class Masa_Corporal extends AppCompatActivity {
    private EditText edtPeso,edtAltura,edtEdad;
    private Spinner spinGenero;
    private Button btoCalcular;
    private ListenerCalcular listenerCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_masa__corporal);

        edtPeso=findViewById(R.id.edt_Peso_Id);
        edtAltura=findViewById(R.id.edt_Altura_Id);
        edtEdad=findViewById(R.id.edt_Edad_Id);
        btoCalcular=findViewById(R.id.Btn_Calcular_Id);
        spinGenero=findViewById(R.id.Spin_Genero_Id);

        //Listener
        ListenerCalcular listenerCalcular=new ListenerCalcular(this);
        //seteo
        btoCalcular.setOnClickListener(listenerCalcular);
    }
}
