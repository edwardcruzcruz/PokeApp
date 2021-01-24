package com.edwardsolution.pokedex.Classes.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.solver.LinearSystem;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;

import com.edwardsolution.pokedex.Classes.Models.PokemonEntry;
import com.edwardsolution.pokedex.R;

import java.util.ArrayList;
import java.util.List;

/*Esta es la clase responsable para cargar los items y manipular la ListaPokemon dentro de
* PokedexActivity.java y activity_pokedex.xml*/


/*2.-) luego de haber creado el objeto contenedor de vistas debemos extender en la clase de nuestro adaptador
* un RecyclerView.Adapter con un tipo de dato "< Type >" Recycler.ViewHolder y finalmente importar los metodos
* que son de caracter obligatorio*/
public class ListPokemonAdapter extends RecyclerView.Adapter<ListPokemonAdapter.ViewHolder> implements Filterable {
    private static final String TAG = "ListPokemnAdapter";
    private List<PokemonEntry>  mpokemonsKanto;
    //Lista  que tiene como destino ser copia de la original para no perder los datos
    private List<PokemonEntry>  mpokemonsKantoFull;
    private Context c;

    public ListPokemonAdapter(Context c,List<PokemonEntry> mpokemonsKanto) {
        this.mpokemonsKanto = mpokemonsKanto;
        this.mpokemonsKantoFull = new ArrayList<>(mpokemonsKanto);
        this.c=c;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {

        LayoutInflater layoutInflater= LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.pokemon_card,parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        String imageName;
        long entry_number=mpokemonsKanto.get(i).getEntry_number();
        if(entry_number>0 && entry_number<10){
            imageName="l00"+entry_number;
        }else if(entry_number>10 && entry_number<100){
            imageName="l0"+entry_number;
        }else {
            imageName="l"+entry_number;
        }
        //imageName="l020";
        Log.v(TAG,"Nombre de la imagen: "+imageName);
        /*Drawable resource using a variable
        * https://stackoverflow.com/questions/7544312/drawable-resource-using-a-variable/7544366*/
        int resID = c.getResources().getIdentifier(imageName, "drawable", c.getPackageName());
        //Log.v(TAG,"Nombre del paquete: "+c.getPackageName());
        //Log.v(TAG,"resID: "+resID);
        Log.v(TAG,"ID: "+i);
        viewHolder.pokeimagen.setImageResource(resID);
        viewHolder.pokenombre.setText(mpokemonsKanto.get(i).getPokemon_species().getName());
    }

    /*3.-)(Explicaciones varias) Basicamente este metodo representa la cantidad de items(rows) presentes
    en algun tiempo dentro del recyclerView

    Dentro de este vemos que retorna por defecto 0, esto es, return 0; sin embargo incialmente
    podemos cambiarle este valor manualmente o hacerlo mas dinamico quizas con una lista o diccionario apropiado
    Ejemplo: combinacion.size()*/
    @Override
    public int getItemCount() {
        return mpokemonsKanto.size();
    }

    @Override
    public Filter getFilter() {
        return pokemonFilter;
    }

    private Filter pokemonFilter = new Filter() {
        /*
        * performFiltering es el metodo que usalmente se llama cuando se desarrolla la accion de
        * busqueda en el fondo
        * */
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<PokemonEntry> filteredList = new ArrayList<>();

            if(constraint == null || constraint.length()==0){
                filteredList.addAll(mpokemonsKantoFull);
            }else{
                String filterPattern = constraint.toString().toLowerCase().trim();
                for (PokemonEntry item : mpokemonsKantoFull){
                    if(item.getPokemon_species().getName().toLowerCase().contains(filterPattern)){
                        filteredList.add(item);
                    }
                }
            }
            FilterResults results = new FilterResults();
            results.values = filteredList;
            return results;
        }
        /*
         * publishResults es el metodo que usalmente se llama cuando se quiere mostrar el
         * resultado de la busqueda  del metodo de arriba
         * */
        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            mpokemonsKanto.clear();
            mpokemonsKanto.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

    /*1.-)Lo primero que debemos hacer al crear el adapter es vincularlo con un objeto contenedor de vistas,
    * esto es cada elemento individual de la lista(Row) esta definido por un objeto tipo contenedor de vistas
    * Ese es el motivo por el cual al crear la clase ViewHolder dentro de nuestro adapter, tenemos que extender
    * de RecyclerView.ViewHolder y luego obligatoriamente android nos recuerda que debemos agregar un super
    * controlador con el mismo nombre de su clase
    *
    * Más info: https://developer.android.com/guide/topics/ui/layout/recyclerview?hl=es-419*/
    class ViewHolder extends RecyclerView.ViewHolder{
        ImageView pokeimagen;
        TextView pokenombre;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            pokeimagen = itemView.findViewById(R.id.imageView);
            pokenombre = itemView.findViewById(R.id.textView);
        }
    }
}
