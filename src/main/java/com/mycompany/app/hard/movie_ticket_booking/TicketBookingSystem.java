package com.mycompany.app.hard.movie_ticket_booking;

import java.util.HashMap;
import java.util.Map;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;
    private Map<String, Theater> theaters;

    private TicketBookingSystem() {
     theaters = new HashMap<String, Theater>();   
    }

    public synchronized static TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }

        return instance;
    }

    public Map<String, Theater> getTheaters() {
        return theaters;
    }

    public void addTheater(Theater theater) {
        theaters.put(theater.getId(), theater);
    }

    public void getMoviesList() {
        for (Theater theater : theaters.values()) {
            System.out.println("Theater: " + theater.getName());
            for(Movie movie: theater.getMovies().values()) {
                System.out.println("- Movie: " + movie.getName());
            }
        }
    }
}
