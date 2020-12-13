package com.svalero.appaprendizaje.listsw.model;

import android.os.AsyncTask;

import com.svalero.appaprendizaje.beans.StarWars;
import com.svalero.appaprendizaje.listsw.contract.List_sw_contract;
import com.svalero.appaprendizaje.utils.Post;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class List_sw_model implements List_sw_contract.Model{

    private static final String URL = "https://swapi.dev/api/people/";
    private ArrayList<StarWars> listArraySw;
    OnListSwListener onListSwListener;

    @Override
    public void getListWS(OnListSwListener onListSwListener) {
        this.onListSwListener = onListSwListener;

        ApiTraveler apiTraveler = new ApiTraveler();
        apiTraveler.execute();
    }

    class ApiTraveler extends AsyncTask<String, Integer, Boolean>{

        @Override
        protected Boolean doInBackground(String... strings) {
            Post post = new Post();

            try {
                JSONObject objectSw = post.getServerDataGetObject(URL);
                JSONArray listSw = objectSw.getJSONArray("results");
                listArraySw = StarWars.getArrayListFromJSON(listSw);
            } catch (JSONException je) {
                je.printStackTrace();
            }

            return true;
        }

        @Override
        protected void onPostExecute(Boolean resp) {
            if(resp) {
                if(listArraySw != null && listArraySw.size() > 0) {
                    onListSwListener.resolve(listArraySw);
                }
            } else {
                onListSwListener.reject("Error al traer los datos del servidor");
            }
        }
    }
}
