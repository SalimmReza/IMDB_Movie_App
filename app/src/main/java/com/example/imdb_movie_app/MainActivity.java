package com.example.imdb_movie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.imdb_movie_app.Adapter.Home_recycler_adapter;
import com.example.imdb_movie_app.Modelss.Search_api_response;
import com.example.imdb_movie_app.listener.On_movie_click_listener;
import com.example.imdb_movie_app.listener.On_search_api_listener;

public class MainActivity extends AppCompatActivity implements On_movie_click_listener {

    SearchView searchView;
    RecyclerView recyclerView;
    Home_recycler_adapter home_recycler_adapter;
    Request_manager manager;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view_id);
        recyclerView = findViewById(R.id.recycler_view_home_id);
       pd= new ProgressDialog(this);
        manager = new Request_manager(this);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
               pd.setTitle("pelase wait");
               pd.show();
                manager.search_movies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });


    }

    private  final On_search_api_listener listener = new On_search_api_listener() {
        @Override
        public void on_response(Search_api_response response) {
            pd.dismiss();
            if (response== null)
            {
                Toast.makeText(MainActivity.this, "No data found..", Toast.LENGTH_SHORT).show();
                return;
            }
            
            show_result(response);
        }

        @Override
        public void onError(String message) {
           pd.dismiss();
            Toast.makeText(MainActivity.this, "Sorry try again!!", Toast.LENGTH_SHORT).show();


        }
    };

    private void show_result(Search_api_response response) {

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
        home_recycler_adapter= new Home_recycler_adapter(this,response.getTitles(),this);
        recyclerView.setAdapter(home_recycler_adapter);
    }

    @Override
    public void on_movie_clicked(String id) {
        Toast.makeText(MainActivity.this, id, Toast.LENGTH_SHORT).show();


    }
}