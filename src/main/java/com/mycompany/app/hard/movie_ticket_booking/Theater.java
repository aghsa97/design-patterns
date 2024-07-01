package com.mycompany.app.hard.movie_ticket_booking;

import java.util.HashMap;
import java.util.Map;

public class Theater {
    private final String id;
    private String name;
    private Map<String, Movie> movies;

    public Theater(String id, String name) {
        this.id = id;
        this.name = name;
        movies = new HashMap<String, Movie>();
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }
}
