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
public class Fragment_ViewPager_Receta extends Fragment {


    private static final String CLAVE_CODIGO_IMAGEN ="codigo imagen" ;
    private static final String CLAVE_CODIGO_TITULO = "codigo titulo";
    private static final String CLAVE_CODIGO_INGREDIENTE = "codigo ingrediente" ;
    private static final String CLAVE_CODIGO_RECETADETALLE = "codigo recetadetalle" ;

    public Fragment_ViewPager_Receta() {
        // Required empty public constructor
    }


    public static Fragment_ViewPager_Receta  DameUnFragment  (int imagen,int titulo,int ingrediente,int recetaDetalle ) {
        //Esta es la fábrica de fragments. Se invocará sin instanciar la clase por ser static

        //Genero un nuevo fragment concreto. Que este método retornará.
        Fragment_ViewPager_Receta fragment_viewPager_receta = new Fragment_ViewPager_Receta();

        //Genero un bundle para poblar el fragment concreto con sus datos
        Bundle bundle = new Bundle();
        bundle.putInt(CLAVE_CODIGO_IMAGEN, imagen);
        bundle.putInt(CLAVE_CODIGO_TITULO, titulo);
        bundle.putInt(CLAVE_CODIGO_INGREDIENTE, ingrediente);
        bundle.putInt(CLAVE_CODIGO_RECETADETALLE, recetaDetalle);

        //Le pongo título que vino por parámetro al fragment concreto
        //fragmentColor.setTitulo(titulo);//
        //Le pongo al fragment el bundle
        fragment_viewPager_receta.setArguments(bundle);
        //Devuelvo el fragment ya con título y con su bundle
        return fragment_viewPager_receta;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__detalle__receta, container, false);
        ImageView imagen = view.findViewById(R.id.fragment_detalle_receta_imagen);
        TextView titulo = view.findViewById(R.id.fragment_detalle_receta_titulo);
        TextView ingredientes = view.findViewById(R.id.fragment_detalle_receta_ingredientes);
        TextView recetaDetalle = view.findViewById(R.id.fragment_detalle_receta_receta);
        //Obtenemos el bundle y le sacamos los argumentos que pasamos
        Bundle bundle = getArguments();
        imagen.setImageResource(bundle.getInt(CLAVE_CODIGO_IMAGEN));
        titulo.setText(bundle.getInt(CLAVE_CODIGO_TITULO));
        ingredientes.setText(bundle.getInt(CLAVE_CODIGO_INGREDIENTE));
        recetaDetalle.setText(bundle.getInt(CLAVE_CODIGO_RECETADETALLE));





        return view;
    }

}
