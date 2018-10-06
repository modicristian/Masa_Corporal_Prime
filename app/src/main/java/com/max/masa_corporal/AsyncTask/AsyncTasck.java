package com.max.masa_corporal.AsyncTask;

import android.app.ProgressDialog;
import android.os.AsyncTask;

public class AsyncTasck extends AsyncTask<Void,Void,String>{
    private ProgressDialog dialogo;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);
    }
}
