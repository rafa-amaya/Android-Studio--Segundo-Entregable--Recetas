package com.example.rafael.recetas;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Detalle_Receta extends Fragment {
    private ImageView imagen;
    private TextView titulo;
    private TextView ingredientes;
    private TextView recetaDetalle;

    public static final String CONTACTO_KEY = "keyContacto";

    public Fragment_Detalle_Receta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__detalle__receta, container, false);
        imagen = view.findViewById(R.id.fragment_detalle_receta_imagen);
        titulo = view.findViewById(R.id.fragment_detalle_receta_titulo);
        ingredientes = view.findViewById(R.id.fragment_detalle_receta_ingredientes);
        recetaDetalle = view.findViewById(R.id.fragment_detalle_receta_receta);


        Bundle bundle = getArguments();
        Receta receta = (Receta) bundle.getSerializable(CONTACTO_KEY);
        imagen.setImageResource(receta.getFoto());
        titulo.setText(receta.getTitulo());
        ingredientes.setText(receta.getIngrediente());
        recetaDetalle.setText(receta.getReceta());

        return  view;
    }

}
