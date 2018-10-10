package com.max.masa_corporal.Listener;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Toast;

import com.max.masa_corporal.Actividad.Masa_Corporal;
import com.max.masa_corporal.Actividad.calcular_tu_masa;

public class ListenerCalcular implements View.OnClickListener{
    private Masa_Corporal context;


    @Override
    public void onClick(View view) {
        Intent intent_Lst_Calcular=new Intent(context,calcular_tu_masa.class);
        guardarValores();
        context.startActivity(intent_Lst_Calcular);
        //pasar datos del main con bolsa a este activity conservarelo en variables shared

    }

}
