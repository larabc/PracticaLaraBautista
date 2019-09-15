package com.example.roompeliculas;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.roompeliculas.model.PeliculaAPI;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class PeliculaAPIAdapter extends ArrayAdapter<PeliculaAPI> {
    int layoutResourceId;

    Context context;

    ArrayList<PeliculaAPI> data;

    public PeliculaAPIAdapter(Context context, int layoutResourceId, ArrayList<PeliculaAPI> data) {
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
        TextView tv_title;
        tv_title = row.findViewById(R.id.tv_titleAPI);

        PeliculaAPI p = data.get(position);

        tv_title.setText(p.getTitle());

        return row;
    }

}
