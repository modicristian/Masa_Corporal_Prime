package com.max.masa_corporal.Usuario;

import android.widget.EditText;
import android.widget.Spinner;

import com.max.masa_corporal.Actividad.Masa_Corporal;

public class Usuario {
    private Masa_Corporal context;
    private EditText edtPeso,edtAltura,edtEdad;
    private Spinner spinGenero;

    public Usuario(EditText edtPeso, EditText edtAltura, EditText edtEdad, Spinner spinGenero) {
        this.edtPeso = edtPeso;
        this.edtAltura = edtAltura;
        this.edtEdad = edtEdad;
        this.spinGenero = spinGenero;
    }

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
}
