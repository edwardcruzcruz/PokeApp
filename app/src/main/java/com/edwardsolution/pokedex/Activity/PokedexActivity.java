package com.edwardsolution.pokedex.Activity;
import android.app.SearchManager;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.edwardsolution.pokedex.Classes.Adapter.ListPokemonAdapter;
import com.edwardsolution.pokedex.Classes.Adapter.ListPokemonAdapter;
import com.edwardsolution.pokedex.Classes.Models.RegionDetail;
import com.edwardsolution.pokedex.Classes.RestService;
import com.edwardsolution.pokedex.R;

public class PokedexActivity extends AppCompatActivity {
    //este es el objeto declarado tipo lista dinamica recyclerview que tenemos en activity_pokedex.xml
    private RecyclerView recyclerView;
    private LinearLayoutManager linerLayoutManger;
    private RegionDetailTask regionDetailTask = null;
    private ListView list;
    private RegionDetail mregionKanto= null;
    // adapter class object
    private ListPokemonAdapter mlistadapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pokedex);
        //instanciamos al objeto antes mencionado en activity_Pokedex.xml con su id respectivox
        recyclerView= findViewById(R.id.recyclerViewListPokemon);
        linerLayoutManger= new GridLayoutManager(this,2);
        //linerLayoutManger= new LinearLayoutManager(this,LinearLayout.VERTICAL,false);
        recyclerView.setLayoutManager(linerLayoutManger);

        regionDetailTask = new RegionDetailTask(2);
        regionDetailTask.execute((Void) null);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search,menu);

        MenuItem searchItem = menu.findItem(R.id.action_search);
        SearchView searchView= (SearchView) searchItem.getActionView();

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                mlistadapter.getFilter().filter(s);
                return false;
            }
        });
        return true;
    }

    /*public void getPokemonbyRegion(View view){
        regionDetailTask = new RegionDetailTask(2);
        regionDetailTask.execute((Void) null);
    }*/

    public class RegionDetailTask extends AsyncTask<Void, Void,RegionDetail> {

        private final long code;

        RegionDetailTask( long code) {
            this.code = code;
        }

        @Override
        protected RegionDetail doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
                RegionDetail resultado = RestService.consultarPokemonsRegion(PokedexActivity.this,this.code);
                System.out.println("Main:"+resultado.toString());
                return resultado;
                /*if(resultado.getStatusCode()==200){

                    boolean seParseo = resultado.loadToken();
                    System.out.println("Se pudo parsear? :"+seParseo);
                    System.out.println("Token:"+resultado.getToken());
                    String tokenprueb=resultado.getToken();
                    if(seParseo){
                        SessionConfig.getSessionConfig(getApplicationContext()).iniciarConfig(Utils.encrypt(resultado.getToken()),this.code);
                        //SharedPreferences preferences = getSharedPreferences("account", MODE_PRIVATE);
                        //SharedPreferences.Editor editor = preferences.edit();
                        //editor.putString(Utils.encrypt("token"), Utils.encrypt(resultado.getToken()));
                        //editor.putString("username",mEmail);
                        //editor.apply(); // Or commit if targeting old devices
                        //editor.commit();
                        return true;
                    }else{
                        return false;
                    }

                }else{
                    return false;
                }*/

            } catch (InterruptedException e) {
                return null;
            }
        }

        @Override
        protected void onPostExecute(final RegionDetail region) {
            if(region!= null){
                mregionKanto=region;
                mlistadapter= new ListPokemonAdapter(getApplicationContext(),mregionKanto.getPokemon_entries());
                recyclerView.setHasFixedSize(true);
                recyclerView.setAdapter(mlistadapter);
                //list = findViewById(R.id.pokemones);


                //ArrayAdapter arrayAdapter = new ArrayAdapter(this,android.R.layout.activity_list_item,region.getPokem);
                //list.setAdapter(arrayAdapter);
            }
        }

        @Override
        protected void onCancelled() {
            //mAuthTaskfacebook = null;
            //showProgress(false);
        }
    }
}
