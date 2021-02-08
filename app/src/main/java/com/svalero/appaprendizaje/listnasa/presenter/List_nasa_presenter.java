package com.svalero.appaprendizaje.listnasa.presenter;

import com.svalero.appaprendizaje.beans.Nasa;
import com.svalero.appaprendizaje.listnasa.contract.List_nasa_contract;
import com.svalero.appaprendizaje.listnasa.model.List_nasa_model;

import java.util.ArrayList;

public class List_nasa_presenter implements List_nasa_contract.Presenter{

    private List_nasa_model list_nasa_model;
    private List_nasa_contract.View vista;
    //private List_nasa_contract.Fragment fragment;

    public List_nasa_presenter(List_nasa_contract.View vista) {
        this.vista = vista;
        list_nasa_model = new List_nasa_model();
    }

    /*public List_nasa_presenter(List_nasa_contract.Fragment fragment) {
        this.fragment = fragment;
    }*/

    @Override
    public void getListNasa() {
        list_nasa_model.getListWS(new List_nasa_contract.Model.OnListNasaListener() {

            @Override
            public void resolve(Nasa nasa) {
                vista.success(nasa);
                //fragment.success(nasa);
            }

            @Override
            public void reject(String error) {
                vista.error("Problemas al traer los datos");
            }
        });
    }
}
