package com.svalero.appaprendizaje.listsw.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.svalero.appaprendizaje.R;
import com.svalero.appaprendizaje.beans.StarWars;

import java.util.ArrayList;

public class ListSwAdapter extends RecyclerView.Adapter<ListSwAdapter.ListSwViewHolder> {

    private ArrayList<StarWars> listStarWars;

    public static class ListSwViewHolder extends RecyclerView.ViewHolder {

        public TextView nombre;

        public ListSwViewHolder(View itemView) {
            super(itemView);
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
        }
    }

    public ListSwAdapter(ArrayList<StarWars> listStarWars) {
        this.listStarWars = listStarWars;
    }

    @NonNull
    @Override
    public ListSwViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_list, parent, false);
        return new ListSwViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListSwViewHolder holder, int position) {
        StarWars starWars = listStarWars.get(position);
        holder.nombre.setText(starWars.getNombre());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

}
