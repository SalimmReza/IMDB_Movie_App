package com.example.imdb_movie_app;

import android.content.Context;
import android.widget.Toast;

import com.example.imdb_movie_app.Modelss.Search_api_response;
import com.example.imdb_movie_app.listener.On_search_api_listener;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class Request_manager {

    Context  context;
    Retrofit retrofit = new Retrofit.Builder().baseUrl("https://imdb-internet-movie-database-unofficial.p.rapidapi.com/")
            .addConverterFactory(GsonConverterFactory.create()).build();

    public Request_manager(Context context) {
        this.context = context;
    }

    public void search_movies(On_search_api_listener listener , String movies_name){
        get_movies get_movies= retrofit.create(Request_manager.get_movies.class);
        Call<Search_api_response>call = get_movies.call_movies(movies_name);
        
        call.enqueue(new Callback<Search_api_response>() {
            @Override
            public void onResponse(Call<Search_api_response> call, Response<Search_api_response> response) {
                if (!response.isSuccessful())
                {
                    Toast.makeText(context, "Couldn't Fetch Data!", Toast.LENGTH_LONG).show();
                return;
                }
                listener.on_response(response.body());
            }

            @Override
            public void onFailure(Call<Search_api_response> call, Throwable t) {

                listener.onError(t.getMessage());
            }
        });
    }

    public interface get_movies{

        @Headers({
                "Accept: application/json",
                "x-rapidapi-host: imdb-internet-movie-database-unofficial.p.rapidapi.com",
                "x-rapidapi-key: c5f665f885msh9ec9d6dd07c74f0p195cdbjsn7d275ecb18c3"
        })
        @GET("search/{movies_name}")
        Call<Search_api_response> call_movies(@Path("movies_name") String movies_name);
    }
}
