package com.mycompany.app.hard.movie_ticket_booking;

import java.util.HashMap;
import java.util.Map;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;
    private Map<String, Theater> theaters;
    private Map<String, Booking> bookings;

    private TicketBookingSystem() {
     theaters = new HashMap<String, Theater>();   
     bookings = new HashMap<String, Booking>();
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

    public void getMoviesList() {
        for (Theater theater : theaters.values()) {
            System.out.println("Theater: " + theater.getName());
            for(Movie movie: theater.getMovies().values()) {
                System.out.println("- Movie: " + movie.getName());
            }
        }
    }
}
