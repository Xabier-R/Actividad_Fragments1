package com.example.actividad_fragments1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;import android.os.Bundle;
public class MainActivity extends AppCompatActivity implements PeliculaListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentListado fragmentListado =
                (FragmentListado)getSupportFragmentManager().
                        findFragmentById(R.id.frgListado);
        fragmentListado.setPeliculaListener(this);
    }

    @Override
    public void onPeliculaSeleccionado(Pelicula p) {
        boolean hayDetalle =(getSupportFragmentManager().findFragmentById(R.id.frgDetalle)!= null);
        if (hayDetalle) {
            ((FragmentDetalle)getSupportFragmentManager().
                    findFragmentById(R.id.frgDetalle)).mostrarDetalle(p);
        }
        else {
            Intent i = new Intent(this, DetalleActivity.class);

            //De 2 Maneras
            i.putExtra(DetalleActivity.EXTRA_TEXTO, p);
            /*
            Bundle bundle = new Bundle();
            bundle.putSerializable(DetalleActivity.EXTRA_TEXTO, p);
            i.putExtras(bundle);
            */
            startActivity(i);
        }
    }
}
