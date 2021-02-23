package com.svalero.appaprendizaje.listnasa.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;
import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.Nasa;
import com.svalero.appaprendizaje.listnasa.DescriptionFragment;
import com.svalero.appaprendizaje.listnasa.MainFragment;
import com.svalero.appaprendizaje.listnasa.contract.List_nasa_contract;
import com.svalero.appaprendizaje.listnasa.presenter.List_nasa_presenter;

public class List_nasa_activity extends AppCompatActivity implements List_nasa_contract.View {

    private List_nasa_presenter list_nasa_presenter;
    private TextView titulo;
    private ImageView imagen;
    private Nasa nasa;         // TODO Progress bar en el layout y solucionar lineas 42 a 54

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_nasa);

        initComponents();

        list_nasa_presenter = new List_nasa_presenter(this);
        list_nasa_presenter.getListNasa();

        titulo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentManager fragmentManager = getSupportFragmentManager();
                Fragment fragment = fragmentManager.findFragmentById(R.id.fragmentContainer);

                System.out.println(fragment);

                /*if(fragment instanceof MainFragment) {
                    showFragment(DescriptionFragment.newInstance(nasa));
                } else {
                    showFragment(MainFragment.newInstance(nasa));
                }*/

                Fragment newFragment = fragment instanceof MainFragment ? DescriptionFragment.newInstance(nasa) : MainFragment.newInstance(nasa);
                showFragment(newFragment);
            }
        });
    }

    public void initComponents() {
        titulo = findViewById(R.id.bTitle);
        imagen = findViewById(R.id.ivImage);
    }

    public void showFragment(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, fragment).commit();
    }

    @Override
    public void onBackPressed() {
        showFragment(MainFragment.newInstance(nasa));
    }

    @Override
    public void success(Nasa nasa) {
       this.nasa = nasa;
       titulo.setText(nasa.getTitulo());
       showFragment(MainFragment.newInstance(nasa));
        Toast.makeText(this, "Hola !!!!!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}