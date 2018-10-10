package com.max.masa_corporal.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;

import com.max.masa_corporal.Actividad.Masa_Corporal;
import com.max.masa_corporal.Usuario.Usuario;

public class SharedPrefe {
    Masa_Corporal context;
    public static void guardarValores(Context cont,String value){
        SharedPreferences sharedPref= cont.getSharedPreferences("preferencias",Context.MODE_PRIVATE);
        SharedPreferences.Editor  editor= sharedPref.edit();
        editor.putInt("peso",)


    }
}
