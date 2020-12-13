package com.svalero.appaprendizaje.listsw.contract;

import com.svalero.appaprendizaje.beans.StarWars;

import java.util.ArrayList;

public interface List_sw_contract {
    interface View {
        void success(ArrayList<StarWars> sw);
        void error(String message);
    }

    interface Presenter {
        void getListSw();
    }

    interface Model {
        void getListWS(OnListSwListener onListSwListener);

        interface OnListSwListener {
            void resolve(ArrayList<StarWars> sw);
            void reject(String error);
        }
    }
}
