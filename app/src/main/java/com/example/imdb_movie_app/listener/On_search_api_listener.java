package com.example.imdb_movie_app.listener;

import com.example.imdb_movie_app.Modelss.Search_api_response;

public interface On_search_api_listener {
    void on_response(Search_api_response response);
    void onError(String message);

}
