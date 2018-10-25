package com.max.masa_corporal.Actividad;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.max.masa_corporal.R;

public class Act_Lista extends AppCompatActivity {
    private ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lista);

        listView = findViewById(R.id.listView);
    }
}
