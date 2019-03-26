package com.example.moviles_practica02;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity
        implements TituloFragment.OnTituloSelectedListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.fragment_container) !=null){
            if (savedInstanceState !=null){
                return;
            }
            TituloFragment tituloFragment = new TituloFragment();

            tituloFragment.setArguments(getIntent().getExtras());

            getSupportFragmentManager()
                    .beginTransaction() //empezar transaccion
                    .add(R.id.fragment_container,
                            tituloFragment)
                    .commit(); //Para realizar accion
        }
    }

    @Override
    public void onTituloSelected(int position) {
        ParrafoFragment parrafoFragment = (ParrafoFragment)getSupportFragmentManager().findFragmentById(R.id.fgm_parrafo);

        if(parrafoFragment != null){
            parrafoFragment.updateParrafoView(position);

        } else { // si es nulo el frag no existe entonces pasamos argumento
            ParrafoFragment parrafoFragment1 = new ParrafoFragment();
            Bundle args = new Bundle();
            args.putInt(ParrafoFragment.ARG_POSITION,position); //agrego argumentos

            parrafoFragment1.setArguments(args);
            //inicia transaccion

            FragmentTransaction fragmentTransaction =
                    getSupportFragmentManager().beginTransaction();


            fragmentTransaction.replace(R.id.fragment_container,parrafoFragment1);
            //GENERAR NUEVO , PILA DE FRAGMENTOS REGRESA AL FRAGMENTO ANTERIOR
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();

        }
    }
}
