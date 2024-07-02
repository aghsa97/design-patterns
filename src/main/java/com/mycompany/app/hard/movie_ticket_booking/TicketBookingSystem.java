package com.mycompany.app.hard.movie_ticket_booking;

import java.util.HashMap;
import java.util.Map;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;
    private Map<String, Movie> movies;
    private Map<String, Theater> theaters;
    private Map<String, Booking> bookings;

    private TicketBookingSystem() {
        movies = new HashMap<String, Movie>();
        theaters = new HashMap<String, Theater>();   
        bookings = new HashMap<String, Booking>();
    }

    public synchronized static TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }

        return instance;
    }

    public Map<String, Movie> getMovies() {
        return movies;
    }

    public Map<String, Theater> getTheaters() {
        return theaters;
    }

    public Map<String, Booking> getBookings() {
        return bookings;
    }

    public void addTheater(Theater theater) {
        theaters.put(theater.getId(), theater);
    }

    public void removeTheater(String theaterId) {
        if (theaters.containsKey(theaterId)) {
            theaters.remove(theaterId);
        }
    }

    public void addBooking(Booking booking) {
        bookings.put(booking.getId(), booking);
    }

    public void removeBooking(String bookingId) {
        if (bookings.containsKey(bookingId)) {
            bookings.remove(bookingId);
        }
    }

    public void addMovie(Movie movie) {
        movies.put(movie.getId(), movie);
    }

    public void removeMovie(Movie movie) {
        movies.remove(movie.getId());
    }

    // methodes -> getMoviesList(); (req 1) ✅
    public void getMoviesList() {
        for(Movie movie: movies.values()) {
            System.out.println("Movie id: " + movie.getId() +" Movie: " + movie.getName());
        }
    }

    public void addMovieToTheater(Movie movie, Theater theater) {
        theater.getMovies().put(movie.getId(), movie);
    }

    public void removeMovieFromTheater(Movie movie, Theater theater) {
        theater.getMovies().remove(movie.getId());
    }

}
