package com.mycompany.app.hard.movie_ticket_booking;

public class Main {
    public static void main( String[] args )
    {
        TicketBookingSystem system = TicketBookingSystem.getInstance();

        System.out.println("Display list of movies: ");
        system.getMoviesList();
    } 
}
