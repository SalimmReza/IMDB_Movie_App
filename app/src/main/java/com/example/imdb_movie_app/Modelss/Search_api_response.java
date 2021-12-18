package com.example.imdb_movie_app.Modelss;

import java.util.List;

public class Search_api_response {
    List<Search_array_objects> titles = null;
    List<Search_array_objects> names = null;
    List<Search_array_objects> companies = null;

    public List<Search_array_objects> getTitles() {
        return titles;
    }

    public void setTitles(List<Search_array_objects> titles) {
        this.titles = titles;
    }

    public List<Search_array_objects> getNames() {
        return names;
    }

    public void setNames(List<Search_array_objects> names) {
        this.names = names;
    }

    public List<Search_array_objects> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Search_array_objects> companies) {
        this.companies = companies;
    }
}



/*
{
        "titles": [
        {
        "title": "Inception",
        "image": "https://m.media-amazon.com/images/M/MV5BMjAxMzY3NjcxNF5BMl5BanBnXkFtZTcwNTI5OTM0Mw@@.jpg",
        "id": "tt1375666"
        },
        {
        "title": "Inception",
        "image": "https://m.media-amazon.com/images/M/MV5BYWJmYWJmNWMtZTBmNy00M2MzLTg5ZWEtOGU5ZWRiYTE0ZjVmXkEyXkFqcGdeQXVyNzkyOTM2MjE@.jpg",
        "id": "tt7321322"
        },
        {
        "title": "Inception",
        "image": "https://m.media-amazon.com/images/M/MV5BNWRmZjcyODktYzkzNS00MjY1LTkxMTctZDJkMjJhODQ1N2RlXkEyXkFqcGdeQXVyMTQ4NDY5OTc@.jpg",
        "id": "tt2242729"
        },
        {
        "title": "Inception: The Cobol Job",
        "image": "https://m.media-amazon.com/images/M/MV5BMjE0NGIwM2EtZjQxZi00ZTE5LWExN2MtNDBlMjY1ZmZkYjU3XkEyXkFqcGdeQXVyNjMwNzk3Mjk@.jpg",
        "id": "tt5295894"
        }
        ],
        "names": [],
        "companies": [
        {
        "title": "Inception",
        "image": null,
        "id": "co0469119"
        },
        {
        "title": "Inception Film Partners",
        "image": null,
        "id": "co0450912"
        },
        {
        "title": "Inception Media Group",
        "image": null,
        "id": "co0287555"
        }
        ]
        }*/
