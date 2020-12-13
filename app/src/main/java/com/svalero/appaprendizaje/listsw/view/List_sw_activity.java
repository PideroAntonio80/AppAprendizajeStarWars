package com.svalero.appaprendizaje.listsw.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.StarWars;
import com.svalero.appaprendizaje.listsw.adapter.ListSwAdapter;
import com.svalero.appaprendizaje.listsw.contract.List_sw_contract;
import com.svalero.appaprendizaje.listsw.presenter.List_sw_presenter;

import java.util.ArrayList;

public class List_sw_activity extends AppCompatActivity implements List_sw_contract.View {

    private List_sw_presenter list_sw_presenter;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager lManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_sw);

        list_sw_presenter = new List_sw_presenter(this);
        list_sw_presenter.getListSw();

        recyclerView = (RecyclerView) findViewById(R.id.rvLista);
        recyclerView.setLayoutManager(lManager);

        lManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(lManager);
    }

    @Override
    public void success(ArrayList<StarWars> sw) {
        ListSwAdapter adapter = new ListSwAdapter(sw);

        recyclerView.setAdapter(adapter);
    }

    @Override
    public void error(String message) {
        Toast.makeText(this, "", Toast.LENGTH_SHORT).show();
    }
}