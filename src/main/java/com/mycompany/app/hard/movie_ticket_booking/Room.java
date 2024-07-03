package com.mycompany.app.hard.movie_ticket_booking;

import java.util.HashMap;
import java.util.Map;

public class Room {
    private final String id;
    private final Theater theater;
    private Map<String, Seat> seats;

    public Room(String id, Theater theater) {
        this.id = id; 
        this.theater = theater;
        seats = new HashMap<String, Seat>();
    }

    public String getId() {
        return id;
    }

    public Theater getTheater() {
        return theater;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }
}
