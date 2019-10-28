package com.example.actividad_fragments1;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.Date;

public class FragmentListado extends Fragment {
   private Pelicula[] pelis =new Pelicula[]{new Pelicula("Star wars", R.drawable.starwars, "2018",153,1111),
                                            new Pelicula("Origen",R.drawable.origen,"2008",170,520),
                                            new Pelicula("El padrino", R.drawable.elpadrino,"1978",190,430),
                                            new Pelicula("Cadena perpetua", R.drawable.cadenaper,"1994",163,463)};

    private ListView lstListado;
    private PeliculaListener listener;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,@Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_listado, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        lstListado = (ListView)getView().findViewById(R.id.lstListado);
        lstListado.setAdapter(new AdaptadorPeliculas(this));
        //Asignamos el evento onItemClick() a la lista de las peliculas
        lstListado.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,View view, int position, long id) {
                if (listener != null)
                    listener.onPeliculaSeleccionado(
                            (Pelicula)lstListado.getAdapter().getItem(position));
            }
        });
    }

class AdaptadorPeliculas extends ArrayAdapter<Pelicula> {
    Activity context;
    AdaptadorPeliculas(Fragment context) {
        super(context.getActivity(), R.layout.listitem_peliculas, pelis);
        this.context = context.getActivity();
    }


        @NonNull
        @Override
        public View getView(int position,@Nullable View convertView,@NonNull ViewGroup parent) {
            LayoutInflater inflater = context.getLayoutInflater();
            View item = inflater.inflate(R.layout.listitem_peliculas, null);
            TextView Titulo = (TextView) item.findViewById(R.id.lblTitulo);
            Titulo.setText(pelis[position].getTitulo());
            ImageView imagen = (ImageView) item.findViewById(R.id.img);
            imagen.setImageResource(pelis[position].getImagen());
            return (item);
        }
    }


    public void setPeliculaListener (PeliculaListener listener){

        this.listener = listener;
    }
}
