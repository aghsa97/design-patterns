package com.mycompany.app.hard.movie_ticket_booking;

public class Main {
    public static void main( String[] args )
    {
        TicketBookingSystem system = TicketBookingSystem.getInstance();

        Movie troy = new Movie("1", "troy", 150);
        Movie spiderman = new Movie("2", "spider man", 120);
        Movie the_dark_knight = new Movie("3", "the dark knight", 170);

        Theater bio = new Theater("1", "bio");
        Theater bio2 = new Theater("2", "bio2");

        system.addTheater(bio);
        system.addTheater(bio2);

        bio.addMovie(troy);
        bio.addMovie(spiderman);
        bio2.addMovie(the_dark_knight);

        system.getMoviesList();
    } 
}
