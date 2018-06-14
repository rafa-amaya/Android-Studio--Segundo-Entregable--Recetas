package com.example.rafael.recetas;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;


public class Main2Activity extends AppCompatActivity {
    public List<Fragment_ViewPager_Receta> listafragment_viewPager_receta;
    public static final String POSICION_KEY = "posicion clikeada";
    public static final String RECETAS_KEY = "Recetas Key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        listafragment_viewPager_receta = new ArrayList<>();
        Intent intent =  getIntent();
        Bundle bundle = intent.getExtras();
        List<Receta> litaRecetas = (List<Receta>) bundle.getSerializable(RECETAS_KEY);
        int posicionclikeada = bundle.getInt(POSICION_KEY);
        cargarFragmentsHardcodeados(litaRecetas);

        //Encuentro el viewPager
        final ViewPager viewPager = findViewById(R.id.viewPager);
        final Adapter_ViewPager_FragmentReceta adapter_viewPager_fragmentReceta =
                new Adapter_ViewPager_FragmentReceta(getSupportFragmentManager(), listafragment_viewPager_receta );

        viewPager.setAdapter(adapter_viewPager_fragmentReceta);

        viewPager.setCurrentItem(posicionclikeada);









    }


    private void cargarFragmentsHardcodeados(List<Receta> listaReceta) {
        //Método que hardcodea los fragments y los agrega a la lista que tenemos como atributo

        for (Receta unareceta:listaReceta) {
            int imagen = unareceta.getFoto();
            int titulo = unareceta.getTitulo();
            int ingredientes = unareceta.getIngrediente();
            int recetaDetalle = unareceta.getReceta();
            listafragment_viewPager_receta.add(Fragment_ViewPager_Receta.DameUnFragment (imagen,titulo,ingredientes,recetaDetalle));
        }




    }
}
