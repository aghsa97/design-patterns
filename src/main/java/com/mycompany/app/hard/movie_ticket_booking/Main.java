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

        User mou = new User("1", "mou");

        LocalDateTime troyTime = LocalDateTime.of(2024, 12, 5, 16, 15);
        LocalDateTime spidermanTime = LocalDateTime.of(2024, 9, 20, 14, 00);
        LocalDateTime batmanTime = LocalDateTime.of(2024, 2, 10, 10, 00);
        LocalDateTime supermanTime = LocalDateTime.of(2024, 10, 20, 3, 15);

        Room room = new Room("1", bio);
        Room room2 = new Room("2", bio);
        Room room3 = new Room("3", bio2);
        Room room4 = new Room("4", bio2);
        Room room5 = new Room("5", bio3);

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
        
        
        system.addRoomToTheater(room, room.getTheater());
        system.addRoomToTheater(room2, room2.getTheater());
        system.addRoomToTheater(room3, room3.getTheater());
        system.addRoomToTheater(room4, room4.getTheater());
        system.addRoomToTheater(room5, room5.getTheater());

        system.addShowTimeToMovieInTheater(troyTime, troy.getId(), bio.getId(), room.getId());
        system.addShowTimeToMovieInTheater(spidermanTime, spiderman.getId(), bio.getId(), room2.getId());
        system.addShowTimeToMovieInTheater(batmanTime, batman.getId(), bio2.getId(), room3.getId());
        system.addShowTimeToMovieInTheater(supermanTime, superman.getId(), bio3.getId(), room5.getId());

        system.makeSeats(room, 10, 4);
        system.makeSeats(room2, 10, 1);
        system.makeSeats(room3, 10, 6);
        system.makeSeats(room4, 10, 2);
        system.makeSeats(room5, 10, 3);

        system.makeBooking(mou);
        system.getBookingList();
    } 
}
