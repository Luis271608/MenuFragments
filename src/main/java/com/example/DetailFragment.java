package com.example;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.menufragments.R;

public class DetailFragment  extends Fragment {

    private Integer indice = -1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Bundle arguments = getArguments();
        if (arguments != null) {
            indice = arguments.getInt("Indice");
        }

        View rootview =  inflater.inflate(R.layout.fragment_detail, container, false);

        String [] clientes = getResources().getStringArray(R.array.alumnos);

        TextView txtv = (TextView) rootview.findViewById(R.id.textView);
        ImageView imgv = (ImageView) rootview.findViewById(R.id.imageView);

        if(indice < 0) {
            txtv.setText(getResources().getString(R.string.sin_alumnos_warning));
        } else {
            txtv.setText(clientes[indice]);
            imgv.setImageResource(getResources().
                    getIdentifier("img"+indice.toString(),
                            "drawable", getActivity().getPackageName()));

        }

        return rootview;
    }
}

