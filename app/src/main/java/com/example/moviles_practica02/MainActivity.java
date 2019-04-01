package com.example.moviles_practica02;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements TituloFragment.OnTituloSelectedListener{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(findViewById(R.id.fragment_container)!=null){
            if(savedInstanceState==null){
                TituloFragment tituloFragment =new TituloFragment();
                tituloFragment.setArguments(getIntent().getExtras());
                getSupportFragmentManager()
                        .beginTransaction()
                        .add(R.id.fragment_container,tituloFragment)
                        .addToBackStack(null)
                        .commit();
            }
        }
    }

    @Override
    public void onTituloSelected(int position) {

        ParrafoFragment parrafoFragment=(ParrafoFragment) getSupportFragmentManager().findFragmentById(R.id.fragment_parrafo);
        if(parrafoFragment!=null){
            parrafoFragment.updateParrafoView(position);
            parrafoFragment.updateDetalleView(position);
        }else{
            ParrafoFragment fragmentoNuevo=new ParrafoFragment();
            Bundle args=new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position);
            fragmentoNuevo.setArguments(args);

            FragmentTransaction fragmentTransaction=getSupportFragmentManager().beginTransaction();

            fragmentTransaction.replace(R.id.fragment_container,fragmentoNuevo);

            fragmentTransaction.addToBackStack(null);

            fragmentTransaction.commit();
        }
    }
}
