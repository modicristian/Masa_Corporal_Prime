package com.max.masa_corporal.SharedPreference;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import java.util.Map;
import java.util.Set;

public class SharedPrefe {
public static void setSharedPreferenceVar(Context c, String value){
    SharedPreferences sharedPreferences=new SharedPreferences("myShared",Context.MODE_PRIVATE);
    SharedPreferences.Editor editor=sharedPreferences.edit();
}
}
