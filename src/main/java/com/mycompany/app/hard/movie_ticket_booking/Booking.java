package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDateTime;

public class Booking {
    private final String id;
    private final User user;
    private Seat seat;
    private Theater theater;
    private LocalDateTime date;
    private Movie movie;

    public Booking(String id, User user, Theater theater, Movie movie, Seat seat, LocalDateTime date) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.theater = theater;
        this.seat = seat;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public Theater getTheater() {
        return theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

}
