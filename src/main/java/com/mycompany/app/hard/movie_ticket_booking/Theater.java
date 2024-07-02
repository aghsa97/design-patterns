package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class Theater {
    private final String id;
    private String name;
    private Map<String, Movie> movies;
    private Map<String, Map<String, LocalDateTime>> theaterSchedule;

    public Theater(String id, String name) {
        this.id = id;
        this.name = name;
        movies = new HashMap<String, Movie>();
        theaterSchedule = new HashMap<String, Map<String, LocalDateTime>>();
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

    public Map<String, Map<String, LocalDateTime>> getTheaterSchedule() {
        return theaterSchedule;
    }

    public void setName(String name) {
        this.name = name;
    }

}
