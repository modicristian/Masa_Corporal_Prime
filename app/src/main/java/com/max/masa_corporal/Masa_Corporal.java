package com.max.masa_corporal;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Masa_Corporal extends AppCompatActivity {
    private EditText edtPeso,edtAltura,edtEdad;
    private Spinner spinGenero;
    private Button btoCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.acty_masa__corporal);

        edtPeso=findViewById(R.id.edt_Peso_Id);
        edtAltura=findViewById(R.id.edt_Altura)
    }
}
