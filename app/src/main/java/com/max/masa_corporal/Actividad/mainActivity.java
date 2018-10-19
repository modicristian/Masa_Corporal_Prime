package com.max.masa_corporal.Actividad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.max.masa_corporal.R;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class mainActivity extends AppCompatActivity {
    private EditText edtPeso,edtAltura,edtEdad;
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


        SharedPreferences preferences=getSharedPreferences("valores",Context.MODE_PRIVATE);
        //EditText
        edtPeso.setText(preferences.getString("peso"," "));
        edtAltura.setText(preferences.getString("altura"," "));
        Long valorCombo = preferences.getLong("genero",0l);
        spinGenero.setSelection( valorCombo.intValue() );
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

        new jsonMasa(peso, altura, genero, edad).execute("https://bmi.p.mashape.com/");

        Intent intent = new Intent(this,calcular_tu_masa.class);
        this.startActivity(intent);

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

        String data = "";

        jsonMasa(String peso, String altura, Long genero,String edad){
            String generoJson="";
            if(genero==1){generoJson="m";}
            if(genero==2){generoJson="f";}
            data = "{ \"weight\": { \"value\": \""+peso+"\", \"unit\": \"kg\" }, \"height\": { \"value\":\""+altura+"\", \"unit\": \"cm\" }, \"sex\": \""+generoJson+"\", \"age\":\""+edad+"\",\"waist\": \"34.00\", \"hip\": \"40.00\" }\n";
            //data = "{ \"weight\": { \"value\": \"85.00\", \"unit\": \"kg\" }, \"height\": { \"value\": \"169.00\", \"unit\": \"cm\" }, \"sex\": \"m\", \"age\": \"40\", \"waist\": \"34.00\", \"hip\": \"40.00\" }\n";

        }

        @Override
        protected String doInBackground(String... urls) {
            InputStream inputStream = null;
            String result = "";
            HttpURLConnection httpcon;



            try {
                //Connect
                httpcon = (HttpURLConnection) ((new URL (urls[0]).openConnection()));
                httpcon.setDoOutput(true);
                httpcon.setRequestProperty("X-Mashape-Key", "hRtSku8fDqmsh7SAIsKMaGABTE9up1iXrzjjsnJUbVJImKtDfF");
                httpcon.setRequestProperty("Content-Type", "application/json");
                httpcon.setRequestProperty("Accept", "application/json");
                httpcon.setRequestMethod("POST");
                httpcon.connect();

                //Write
                OutputStream os = httpcon.getOutputStream();
                BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));
                writer.write(data);
                writer.close();
                os.close();

                //Read
                BufferedReader br = new BufferedReader(new InputStreamReader(httpcon.getInputStream(),"UTF-8"));

                String line = null;
                StringBuilder sb = new StringBuilder();

                while ((line = br.readLine()) != null) {
                    sb.append(line);
                }

                br.close();
                result = sb.toString();

            } catch (Exception e) {
                // ERROR;
                Log.d("InputStream", e.getLocalizedMessage());
            }
            return result;
        }

        @Override
        protected void onPostExecute(String s) {

            try{
                JSONObject jsonObject = new JSONObject(s);
                JSONObject jsonBmi=jsonObject.getJSONObject("bmi");

                String valueJason =jsonBmi.getString("value");
                String statusJason= jsonBmi.getString("status");
                String ideal_weightJason =jsonObject.getString("ideal_weight");
                String riskJason= jsonBmi.getString("risk");

            /*<<<<Paso los valores obtenidos por el sharedPreference>>>>>*/
                SharedPreferences shared = getSharedPreferences("valores",Context.MODE_PRIVATE);

                SharedPreferences.Editor editor = shared.edit();

                editor.putString("value",valueJason);
                editor.putString("status",statusJason);
                editor.putString("ideal_weight",ideal_weightJason);
                editor.putString("risk",riskJason);

                editor.commit();


            } catch (Exception e) {

                // Cualquier problema en la lectura del JSON, se ir� por este camino.
                Toast.makeText(mainActivity.this, "Hubo un problema", Toast.LENGTH_LONG).show();
            }

        }
    }
    }

