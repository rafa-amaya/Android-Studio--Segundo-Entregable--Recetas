package com.example.rafael.recetas;


import android.content.Intent;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener,Fragment_Receta.NotificadorContacto {
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        navigationView = findViewById(R.id.navigation_view);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView.setNavigationItemSelectedListener(this);


    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.recetas:
                fragment = new Fragment_Receta();
                break;
            case R.id.about:
                fragment = new Fragment_About();
                break;
        }
        cargarFragment(fragment);
        drawerLayout.closeDrawers();
        return true;
    }
    public void cargarFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.contenedor_fragment, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void notificar(int posicionclikeada,List <Receta> listaRecetas) {

        ArrayList<Receta> recetas = (ArrayList) listaRecetas;
        Intent intent = new Intent(this, Main2Activity.class);
        Bundle bundle = new Bundle();
        bundle.putInt(Main2Activity.POSICION_KEY,posicionclikeada);
        bundle.putSerializable(Main2Activity.RECETAS_KEY, recetas);
        intent.putExtras(bundle);
        startActivity(intent);





/*        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList(Fragment_Detalle_Receta.CONTACTO_KEY, (ArrayList<? extends Parcelable>) receta);
        Fragment_Detalle_Receta fragmentDetalleReceta = new Fragment_Detalle_Receta();
        fragmentDetalleReceta.setArguments(bundle);
        cargarFragment(fragmentDetalleReceta);*/

    }
}
