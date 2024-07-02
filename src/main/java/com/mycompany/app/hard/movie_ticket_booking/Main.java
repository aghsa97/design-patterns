package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDateTime;

public class Main {
    public static void main( String[] args )
    {
        TicketBookingSystem system = TicketBookingSystem.getInstance();

        Theater bio = new Theater("1", "bio");
        Theater bio2 = new Theater("2", "bio2");
        Theater bio3 = new Theater("3", "bio3");

        Movie troy = new Movie("1", "troy", 140);
        Movie spiderman = new Movie("2", "spiderman", 140);
        Movie batman = new Movie("3", "batman", 140);
        Movie superman = new Movie("4", "superman", 140);

        User mou = new User("1", "mou", false);

        LocalDateTime troyTime = LocalDateTime.of(2024, 12, 5, 16, 15);
        LocalDateTime spidermanTime = LocalDateTime.of(2024, 9, 20, 14, 00);
        LocalDateTime batmanTime = LocalDateTime.of(2024, 2, 10, 10, 00);
        LocalDateTime supermanTime = LocalDateTime.of(2024, 10, 20, 3, 15);

        system.addTheater(bio);
        system.addTheater(bio2);
        system.addTheater(bio3);

        system.addMovie(troy);
        system.addMovie(spiderman);
        system.addMovie(batman);
        system.addMovie(superman);

        system.addUser(mou);

        system.addMovieToTheater(troy, bio);
        system.addMovieToTheater(spiderman, bio);
        system.addMovieToTheater(batman, bio2);
        system.addMovieToTheater(superman, bio3);
        
        system.addShowTimeToMovieInTheater(troyTime, troy.getId(), bio.getId());
        system.addShowTimeToMovieInTheater(spidermanTime, spiderman.getId(), bio.getId());
        system.addShowTimeToMovieInTheater(batmanTime, batman.getId(), bio2.getId());
        system.addShowTimeToMovieInTheater(supermanTime, superman.getId(), bio3.getId());

        system.makeBooking(mou);
        system.getBookingList();
    } 
}
