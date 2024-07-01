package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDate;

public class Booking {
    private final String id;
    private final User user;
    private Theater theater;
    private LocalDate date;
    private Movie movie;

    public Booking(String id, User user, Theater theater, Movie movie,LocalDate date) {
        this.id = id;
        this.user = user;
        this.movie = movie;
        this.theater = theater;
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public LocalDate getDate() {
        return date;
    }

    public Theater getTheater() {
        return theater;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public void setTheater(Theater theater) {
        this.theater = theater;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

}
