package com.svalero.appaprendizaje.listnasa.contract;

import com.svalero.appaprendizaje.beans.Nasa;

import java.util.ArrayList;

public interface List_nasa_contract {
    /*interface Fragment {
        void success(Nasa nasa);
    }*/

    interface View {
        void success(Nasa nasa);
        void error(String message);
    }

    interface Presenter {
        void getListNasa();
    }

    interface Model {
        void getListWS(OnListNasaListener onListSNasaListener);

        interface OnListNasaListener {
            void resolve(Nasa nasa);
            void reject(String error);
        }
    }
}
