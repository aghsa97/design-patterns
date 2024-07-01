package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Movie {
    private final String id;
    private String name;
    private int duration;
    private List<LocalDate> availableTimes;

    public Movie(String id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        availableTimes = new ArrayList<LocalDate>();
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

    public List<LocalDate> getAvailableTimes() {
        return availableTimes;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public void setAvailableTimes(LocalDate availableTime) {
        if (!availableTimes.contains(availableTime)) {
            availableTimes.add(availableTime);
        }
    }

    public void removeTime(LocalDate date) {
        availableTimes.remove(date);
    }
}
