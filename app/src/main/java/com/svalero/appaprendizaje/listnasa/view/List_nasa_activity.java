package com.svalero.appaprendizaje.listnasa.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.Nasa;
import com.svalero.appaprendizaje.listnasa.DescriptionFragment;
import com.svalero.appaprendizaje.listnasa.contract.List_nasa_contract;
import com.svalero.appaprendizaje.listnasa.presenter.List_nasa_presenter;

public class List_nasa_activity extends AppCompatActivity implements List_nasa_contract.View {

    private List_nasa_presenter list_nasa_presenter;
    private Button titulo;
    private ImageView imagen;
    private DescriptionFragment fragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nasa);

        initComponents();

        list_nasa_presenter = new List_nasa_presenter(this);
        list_nasa_presenter.getListNasa();

        titulo.setOnClickListener(new View.OnClickListener() {  //Operador ternario para que el mismo botón cambie del fragment a la activity y viceversa
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.replace(R.id.fragmentContainer,fragment).commit();
            }
        });
    }

    public void initComponents() {
        titulo = findViewById(R.id.bTitle);
        imagen = findViewById(R.id.ivImage);
        fragment = new DescriptionFragment();
    }

    @Override
    public void success(Nasa nasa) {
       titulo.setText(nasa.getTitle());
       Picasso.get().load(nasa.getUrl()).into(imagen);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}