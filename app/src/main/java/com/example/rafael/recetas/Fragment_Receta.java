package com.example.rafael.recetas;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Receta extends Fragment implements Adapter_Receta.NotificadorContactoCelda {
    private RecyclerView recyclerView;
    private List<Receta> recetas;
    private NotificadorContacto notificadorContacto;
    private EditText editText;
    private Adapter_Receta adapter_receta;


    public Fragment_Receta() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment__receta, container, false);
        recyclerView = view.findViewById(R.id.recycler_id);
        editText = view.findViewById(R.id.fragment_receta_edittext);
        armarListadoRecetas();

        adapter_receta = new Adapter_Receta(recetas,this);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL,false));
        recyclerView.setAdapter(adapter_receta);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                filtro(s.toString());

            }
        });
        return view;
    }

    public void filtro(String text){
       ArrayList<Receta> listaFiltrada = new ArrayList<>();
        for (Receta unareceta:recetas) {
            String texto = getString(unareceta.getTitulo());

            if (texto.toLowerCase().contains(text.toLowerCase())){
                listaFiltrada.add(unareceta);
            }
        }
        adapter_receta.listafiltrada(listaFiltrada);
    }

    public void onAttach (Context context) {
        super.onAttach(context);
        notificadorContacto = (NotificadorContacto) context;
    }


    private void armarListadoRecetas() {
        recetas = new ArrayList<>();
        recetas.add(new Receta(R.mipmap.tarta_de_chocolate_sin_harina,R.string.receta_titulo,R.string.receta_ingredientes,R.string.receta_receta));
        recetas.add(new Receta(R.mipmap.receta2,R.string.receta_titulo2,R.string.receta_ingredientes2,R.string.receta_receta2));
        recetas.add(new Receta(R.mipmap.receta3,R.string.receta_titulo3,R.string.receta_ingredientes3,R.string.receta_receta3));
        recetas.add(new Receta(R.mipmap.receta4,R.string.receta_titulo4,R.string.receta_ingredientes4,R.string.receta_receta4));
        recetas.add(new Receta(R.mipmap.receta5,R.string.receta_titulo5,R.string.receta_ingredientes5,R.string.receta_receta5));
    }


    @Override
    public void notificarContactoClickeado(int posicionclikeada,List<Receta> receta) {
        notificadorContacto.notificar(posicionclikeada,receta);
    }


    public interface NotificadorContacto {
        public void notificar(int posicionclikeada,List <Receta> receta);
    }}
