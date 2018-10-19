package com.max.masa_corporal.Actividad;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

import com.max.masa_corporal.R;

public class calcular_tu_masa extends AppCompatActivity {
    private TextView editTuMasa,editTuEstado,editTuPesoIdeal,editTuRiesgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_calcular_tu_masa);

        editTuMasa = findViewById(R.id.editTuMasa);
        editTuEstado = findViewById(R.id.editTuEstado);
        editTuPesoIdeal = findViewById(R.id.editTuPesoIdeal);
        editTuRiesgo = findViewById(R.id.editTuRiesgo);

        SharedPreferences sharedPreferences = getSharedPreferences("valores", Context.MODE_PRIVATE);

        String masa =  sharedPreferences.getString("value","");
        String estado = sharedPreferences.getString("status","");
        String pesoIdeal = sharedPreferences.getString("ideal_weight","");
        String riesgo = sharedPreferences.getString("risk","");

        editTuMasa.setText(masa);
        editTuEstado.setText(estado);
        editTuPesoIdeal.setText(pesoIdeal);
        editTuRiesgo.setText(riesgo);
    }
}
