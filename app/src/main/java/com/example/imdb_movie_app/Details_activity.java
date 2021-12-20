package com.example.imdb_movie_app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.imdb_movie_app.Adapter.Cast_recyclerAddapter;
import com.example.imdb_movie_app.Adapter.Home_recycler_adapter;
import com.example.imdb_movie_app.Modelss.Details_api_class;
import com.example.imdb_movie_app.listener.On_details_api_listener;
import com.squareup.picasso.Picasso;

public class Details_activity extends AppCompatActivity {

     TextView movies_title, movies_released, movie_runtime, movie_rating, movie_votes,text_view_movie_plot;
    ImageView movie_poster;
    RecyclerView recyclerView_movie_cast;

    Cast_recyclerAddapter addapter;
    Request_manager manager;
    ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        movies_title= findViewById(R.id.movie_name_id);
        movies_released= findViewById(R.id.movie_name_released_id);
        movie_runtime= findViewById(R.id.movie_runtime_id);
        movie_rating= findViewById(R.id.movie_rating_id);
        movie_votes= findViewById(R.id.movie_votes_id);
        movie_poster= findViewById(R.id.image_view_movie_poster_id);
        recyclerView_movie_cast= findViewById(R.id.recycler_movie_cast_id);
        text_view_movie_plot = findViewById(R.id.text_view_movie_plot);


        manager = new Request_manager(this);
       String movie_id= getIntent().getStringExtra("data");
        pd= new ProgressDialog(this);
        pd.setTitle("Loading...");
        pd.show();
       manager.search_movies_details(listener, movie_id);









    }

    private On_details_api_listener listener = new On_details_api_listener() {
        @Override
        public void onResponse(Details_api_class details_api_class) {
            pd.dismiss();
            if (details_api_class== null)
            {
                Toast.makeText(Details_activity.this, "No data found..", Toast.LENGTH_SHORT).show();
                return;
            }

            
            show_result(details_api_class);
        }

        @Override
        public void onError(String message) {
            pd.dismiss();
            Toast.makeText(Details_activity.this, "Sorry try again!!", Toast.LENGTH_SHORT).show();

        }
    };

    private void show_result(Details_api_class details_api_class) {

        movies_title.setText(details_api_class.getTitle());
        movies_released.setText("Year Released: " +details_api_class.getYear());
                movie_runtime.setText("Length: " + details_api_class.getLength());
                movie_rating.setText("Rating: " + details_api_class.getRating());
                movie_votes.setText("Votes: " + details_api_class.getRating_votes());
                text_view_movie_plot.setText(details_api_class.getPlot());

        try{
            Picasso.get().load(details_api_class.getPoster()).into(movie_poster);
        }catch (Exception e)
        {
            e.printStackTrace();
        }





        recyclerView_movie_cast.setHasFixedSize(true);
        recyclerView_movie_cast.setLayoutManager(new GridLayoutManager(Details_activity.this,1));
        addapter = new Cast_recyclerAddapter(this,details_api_class.getCast());
        recyclerView_movie_cast.setAdapter(addapter);

    }
}