package com.example.moviles_practica02;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class ParrafoFragment extends Fragment {

    final static String ARG_POSITION= "position";
    int mCurrentPosition=-1;

    public void updateParrafoView(int position){
        TextView parrafo = (TextView) getActivity().findViewById(R.id.txt_fragmento);
        parrafo.setText(Contenido.Parrafos[position]);
        mCurrentPosition=position;
    }
    public void updateDetalleView (int position){
        TextView textView1 = (TextView) getActivity().findViewById(R.id.txt_detalle); //añadiendo detalle
        textView1.setText(Contenido.detalles[position]);
        mCurrentPosition = position;
    }

    @Override
    public void onStart(){
        super.onStart();
        Bundle args=getArguments();
        if(args!=null){
            updateParrafoView(args.getInt(ARG_POSITION));
            updateDetalleView(args.getInt(ARG_POSITION));
        }else if(mCurrentPosition!=-1){
            updateParrafoView(mCurrentPosition);
            updateDetalleView(mCurrentPosition);
        }

    }
    @Override
    public void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(ARG_POSITION,mCurrentPosition);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
        return inflater.inflate(R.layout.fragment_parrafo,container,false);
    }
}
