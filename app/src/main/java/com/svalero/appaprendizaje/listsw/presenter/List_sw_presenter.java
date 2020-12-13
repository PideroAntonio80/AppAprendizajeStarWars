package com.svalero.appaprendizaje.listsw.presenter;

import com.svalero.appaprendizaje.beans.StarWars;
import com.svalero.appaprendizaje.listsw.contract.List_sw_contract;
import com.svalero.appaprendizaje.listsw.model.List_sw_model;

import java.util.ArrayList;

public class List_sw_presenter implements List_sw_contract.Presenter{

    private List_sw_model list_sw_model;
    private List_sw_contract.View vista;

    public List_sw_presenter(List_sw_contract.View vista) {
        this.vista = vista;
        list_sw_model = new List_sw_model();
    }

    @Override
    public void getListSw() {
        list_sw_model.getListWS(new List_sw_contract.Model.OnListSwListener() {

            @Override
            public void resolve(ArrayList<StarWars> sw) {
                vista.success(sw);
            }

            @Override
            public void reject(String error) {
                vista.error("Problemas al traer los datos");
            }
        });
    }
}
