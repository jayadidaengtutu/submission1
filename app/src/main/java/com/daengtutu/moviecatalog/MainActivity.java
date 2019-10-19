package com.daengtutu.moviecatalog;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private String[] dataJudul;
    private String[] dataDeskripsi;
    private TypedArray dataPoster;
    private MovieAdapter adapter;
    private ArrayList<Movie> movies;
    private String title ="Movie Catalog";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setActionBarTitle(title);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        adapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.daftar);
        listView.setAdapter(adapter);

        prepare();
        addItem();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(MainActivity.this, movies.get(i).getJudul(), Toast.LENGTH_SHORT).show();
                Person person = new Person();
                person.setPoster(dataPoster.getResourceId(i,-1));
                person.setJudul(dataJudul[i]);
                person.setDeskripsi(dataDeskripsi[i]);

                Intent detailmovieintent = new Intent(MainActivity.this, DetailMovie.class);
                detailmovieintent.putExtra(DetailMovie.EXTRA_PERSON, person);
                startActivity(detailmovieintent);
            }
        });
    }

    private void addItem(){
        movies = new ArrayList<>();

        for (int i=0; i<dataJudul.length; i++){
            Movie movie = new Movie();
            movie.setPoster(dataPoster.getResourceId(i, -1));
            movie.setJudul(dataJudul[i]);
            movie.setDeskripsi(dataDeskripsi[i]);
            movies.add(movie);
        }
        adapter.setMovies(movies);
    }

    private void prepare(){
        dataJudul = getResources().getStringArray(R.array.data_judul);
        dataDeskripsi = getResources().getStringArray(R.array.data_deskripsi);
        dataPoster = getResources().obtainTypedArray(R.array.data_poster_Movie);
    }

    private void setActionBarTitle(String title){
        if (getSupportActionBar() != null){
           getSupportActionBar().setTitle(title);
        }
    }
}
