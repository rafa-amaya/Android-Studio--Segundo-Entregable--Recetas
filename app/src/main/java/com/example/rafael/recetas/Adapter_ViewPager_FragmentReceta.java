package com.example.rafael.recetas;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;


import java.util.List;

public class Adapter_ViewPager_FragmentReceta extends FragmentStatePagerAdapter {
    private List<Fragment_ViewPager_Receta> listaFragments;


    public Adapter_ViewPager_FragmentReceta(FragmentManager fm,List<Fragment_ViewPager_Receta> listaFragments) {
        super(fm);
        this.listaFragments = listaFragments;
    }

    @Override
    public Fragment getItem(int position) {
        return listaFragments.get(position);
    }

    @Override
    public int getCount() {
        return listaFragments.size();
    }


}
