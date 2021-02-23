package com.svalero.appaprendizaje.listnasa.model;

import android.os.AsyncTask;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.svalero.appaprendizaje.beans.Nasa;
import com.svalero.appaprendizaje.listnasa.contract.List_nasa_contract;
import com.svalero.appaprendizaje.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;

public class List_nasa_model implements List_nasa_contract.Model{

    private static final String URL = "https://api.nasa.gov/planetary/apod?date=2021-02-12&api_key=hqbqc7iPtyZFVM91Vsnth3mQTcnnzC5KtENaKVwM";
    OnListNasaListener onListNasaListener;

    @Override
    public void getListWS(OnListNasaListener onListNasaListener) {
        this.onListNasaListener = onListNasaListener;
        ApiTraveler apiTraveler = new ApiTraveler();
        apiTraveler.execute();
    }

    class ApiTraveler extends AsyncTask<String, Integer, Nasa>{

        @Override
        protected Nasa doInBackground(String... strings) {
            Post post = new Post();
            Gson gson = new Gson();

            try {
                JSONObject objectNasa = post.getServerDataGetObject(URL);
                Nasa nasaObject = gson.fromJson(String.valueOf(objectNasa), Nasa.class);
                return nasaObject;
            } catch (JsonSyntaxException jse) {
                return null;
            }
        }

        /*@Override
        protected void onProgressUpdate(Integer... values) {
            progressBar.setProgress(values[0]);
        }*/

        @Override
        protected void onPostExecute(Nasa nasaObj) {

            if(nasaObj != null ) {
                onListNasaListener.resolve(nasaObj);
            }
            else {
                onListNasaListener.reject("Error al traer los datos del servidor");
            }
        }
    }
}
