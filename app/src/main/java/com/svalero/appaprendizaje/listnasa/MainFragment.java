package com.svalero.appaprendizaje.listnasa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.Nasa;

public class MainFragment extends Fragment {

    private static final String EXTRA_NASA = "param1";

    private View view;
    private Nasa nasa;
    private ImageView image;

    public MainFragment() {
    }

    public static MainFragment newInstance(Nasa nasa) {
        MainFragment fragment = new MainFragment();
        Bundle args = new Bundle();
        args.putSerializable(EXTRA_NASA, nasa);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            nasa = (Nasa) getArguments().getSerializable(EXTRA_NASA);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.fragment_main, container, false);

        initViews();

        loadData(nasa);

        return view;
    }

    public void loadData(Nasa nasa) {
        Picasso.get().load(nasa.getUrlImage()).into(image);
    }

    public void initViews() {
        image = view.findViewById(R.id.ivImage);
    }
}