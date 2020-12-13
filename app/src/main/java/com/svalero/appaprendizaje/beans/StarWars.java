package com.svalero.appaprendizaje.beans;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class StarWars {
    private static final String NAME = "name";

    private String nombre;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public static ArrayList<StarWars> getArrayListFromJSON(JSONArray listSw) {
        ArrayList<StarWars> listaSw = null;
        try {
            if(listSw != null && listSw.length() >0) {
                listaSw = new ArrayList<StarWars>();
            }
            for(int i = 0; i < listSw.length(); i++) {
                JSONObject jsonObject = listSw.getJSONObject(i);

                StarWars starWars = new StarWars();

                starWars.setNombre(jsonObject.getString(NAME));

                listaSw.add(starWars);
            }
        } catch (JSONException je) {
            je.printStackTrace();
        }

        return listaSw;
    }
}
