package com.example.imdb_movie_app.listener;

import com.example.imdb_movie_app.Modelss.Details_api_class;

public interface On_details_api_listener {

    void onResponse(Details_api_class details_api_class);
    void onError (String message);
}
