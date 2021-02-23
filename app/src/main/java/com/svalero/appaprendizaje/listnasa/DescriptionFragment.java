package com.svalero.appaprendizaje.listnasa;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;
import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.Nasa;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DescriptionFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DescriptionFragment extends Fragment /*implements List_nasa_contract.Fragment*/ {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String EXTRA_NASA = "param1";

    // TODO: Rename and change types of parameters
    private Nasa nasa;
    private View vista;
    private ImageView image;
    private TextView descripcion, copyright;

    public DescriptionFragment() {
        // Required empty public constructor
    }

    public static DescriptionFragment newInstance(Nasa nasa) {
        DescriptionFragment fragment = new DescriptionFragment();
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

        vista = inflater.inflate(R.layout.fragment_description, container, false);
        initViews();
        loadData(nasa);
        return vista;
    }

    public void loadData(Nasa nasa) {
        copyright.setText(nasa.getCopyright());
        descripcion.setText(nasa.getExplanation());
        Picasso.get().load(nasa.getUrlImage()).into(image);
    }

    public void initViews() {
        copyright = vista.findViewById(R.id.tvCopyright);
        descripcion = vista.findViewById(R.id.tvDescription);
        image = vista.findViewById(R.id.ivImageDescription);
    }

    /*@Override
    public void success(Nasa nasa) {
        copyright.setText(nasa.getCopyright());
        descripcion.setText(nasa.getExplanation());
        //Picasso.get().load(nasa.getUrl()).into(image);
    }*/

}