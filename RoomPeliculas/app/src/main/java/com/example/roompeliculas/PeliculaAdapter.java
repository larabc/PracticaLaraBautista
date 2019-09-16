package com.example.roompeliculas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.roompeliculas.model.Pelicula;

import java.util.ArrayList;

public class PeliculaAdapter extends ArrayAdapter<Pelicula> {
    int layoutResourceId;
    Context context;
    ArrayList<Pelicula> data;

    public PeliculaAdapter(Context context, int layoutResourceId, ArrayList<Pelicula> data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row;
        LayoutInflater inflater = ((Activity) context).getLayoutInflater();
        row = inflater.inflate(layoutResourceId, parent, false);

        TextView tv_title = row.findViewById(R.id.tv_title);
        TextView tv_rating = row.findViewById(R.id.tv_rating);
        String title = data.get(position).getTitle();
        int rating = data.get(position).getRating();

        if (rating==0||rating==1){
            tv_rating.setTextColor(context.getResources().getColor(R.color.colorRed));
        } else if (rating==2||rating==3) {
            tv_rating.setTextColor(context.getResources().getColor(R.color.colorBlack));
        } else {
            tv_rating.setTextColor(context.getResources().getColor(R.color.colorGreen));
        }

        tv_title.setText(title);
        tv_rating.setText(String.valueOf(rating));

        return row;
    }
}
