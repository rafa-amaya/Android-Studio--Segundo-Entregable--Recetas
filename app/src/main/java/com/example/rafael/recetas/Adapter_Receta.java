package com.example.rafael.recetas;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;


public class Adapter_Receta extends RecyclerView.Adapter {
    private List<Receta> recetas;
    private NotificadorContactoCelda notificadorContactoCelda;

    public  Adapter_Receta (List <Receta> recetas,NotificadorContactoCelda notificadorContactoCelda){
        this.recetas = recetas;
        this.notificadorContactoCelda = notificadorContactoCelda;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.celda_recycler_recetas,parent,false);
        ViewHolderReceta viewHolderReceta = new ViewHolderReceta(view);
        return viewHolderReceta;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        Receta receta = recetas.get(position);
        ViewHolderReceta viewHolderReceta = (ViewHolderReceta) holder;
        viewHolderReceta.CargarReceta(receta);
    }

    @Override
    public int getItemCount() {
        if (recetas != null) {
            return recetas.size();
        } else {
            return 0;
        }
    }

    public class ViewHolderReceta extends RecyclerView.ViewHolder{
        private CardView cardView;
        private ImageView imagen;
        private TextView titulo;
        private TextView ingrediente;

        public ViewHolderReceta(View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.celda_recycler_receta_cardView);
            imagen = itemView.findViewById(R.id.celda_recycler_receta_imagen);
            titulo = itemView.findViewById(R.id.celda_recycler_receta_titulo);
            ingrediente = itemView.findViewById(R.id.celda_recycler_receta_ingrediente);


            cardView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    List<Receta> receta = recetas;
                    int posicionclikeada = getAdapterPosition();;
                    notificadorContactoCelda.notificarContactoClickeado(posicionclikeada,receta);
                }
            });
        }

        public void CargarReceta (Receta receta){
            imagen.setImageResource(receta.getFoto());
            titulo.setText(receta.getTitulo());
            ingrediente.setText(receta.getIngrediente());
        }
    }
    //INTERFAZ QUE COMUNICA ADAPTER CON FRAGMENT. EL FRAGMENT ES QUIEN IMPLEMENTA ESTA INTERFAZ
    public interface NotificadorContactoCelda {
        public void notificarContactoClickeado(int posicionclikeada,List<Receta> receta);
    }
}
