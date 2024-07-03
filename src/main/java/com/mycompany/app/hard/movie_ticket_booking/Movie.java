package com.mycompany.app.hard.movie_ticket_booking;

public class Movie {
    private final String id;
    private int duration;
    private String name;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }
}
