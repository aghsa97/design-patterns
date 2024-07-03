package com.mycompany.app.hard.movie_ticket_booking;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Map;

public class TicketBookingSystem {
    private static TicketBookingSystem instance;
    private Map<String, User> users;
    private Map<String, Movie> movies;
    private Map<String, Theater> theaters;
    private Map<String, Booking> bookings;

    private Scanner scanner;

    private TicketBookingSystem() {
        users = new HashMap<String, User>();
        movies = new HashMap<String, Movie>();
        theaters = new HashMap<String, Theater>();   
        bookings = new HashMap<String, Booking>();
        this.scanner = new Scanner(System.in);
    }

    public synchronized static TicketBookingSystem getInstance() {
        if (instance == null) {
            instance = new TicketBookingSystem();
        }

        return instance;
    }

    // methodes -> getMoviesList(); (req 1) ✅
    public void getMoviesList() {
        for(Movie movie: movies.values()) {
            System.out.println("id: " + movie.getId() +" Movie: " + movie.getName());
        }
    }

    public void getTheatersList() {
        for(Theater theater: theaters.values()) {
            System.out.println("id: " + theater.getId() +" theater: " + theater.getName());
        }
    }

    public void getBookingList() {
        for(Booking booking: bookings.values()) {
            System.out.println("Booking Details:");
            System.out.println("id: " + booking.getId());
            System.out.println("theater: " + booking.getTheater().getName());
            System.out.println("Name: " + booking.getUser().getName());
            System.out.println("Date: " + booking.getDate().toLocalDate().toString());
            System.out.println("Time: " + booking.getDate().getHour() + ":" + String.format("%02d", booking.getDate().getMinute())); // Format minute to always have two digits
            System.out.println("Seat Number: " + booking.getSeat().getId());
            System.out.println("Seat Type: " + booking.getSeat().getType());
            System.out.println("Room: " + booking.getSeat().getRoom().getId());
        }
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

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void removeUser(String userId) {
        if (users.containsKey(userId)) {
            users.remove(userId);
        }
    }

    public void addMovieToTheater(Movie movie, Theater theater) {
        theater.getMovies().put(movie.getId(), movie);
        theater.getTheaterSchedule().put(movie.getId(), new HashMap<String, LocalDateTime>());
    }

    public void removeMovieFromTheater(Movie movie, Theater theater) {
        theater.getMovies().remove(movie.getId());
        theater.getTheaterSchedule().remove(movie.getId());
    }

    public void addShowTimeToMovieInTheater(LocalDateTime time, String movieId, String theaterId, String roomId) {
        Theater theater = theaters.get(theaterId);
        theater.getRoomSchadule().put(time.toString() + "MOV_" + String.valueOf(movieId), theater.getRooms().get(roomId));
        Map<String, LocalDateTime> movieShowTimes = getMovieShowTimesWithTheaterId(theaterId, movieId);
        movieShowTimes.put(time.toString(), time);
    }

    public void removeShowTimeToMovieInTheater(LocalDateTime time, String movieId, String theaterId) {
        Theater theater = theaters.get(theaterId);
        theater.getRoomSchadule().remove(time.toString() + "MOV_" + String.valueOf(movieId));
        Map<String, LocalDateTime> movieShowTimes = getMovieShowTimesWithTheaterId(theaterId, movieId);
        movieShowTimes.remove(time.toString());
    }

    public void addRoomToTheater(Room room, Theater theater) {
        theater.getRooms().put(room.getId(), room);
    }

    public void removeRoomFromTheater(String roomId, Theater theater) {
        theater.getRooms().remove(roomId);
    }

    public void addSeatToRoom(Seat seat, Room room) {
        room.getSeats().put(seat.getId(), seat);
        seat.setRoom(room);
    }

    public void removeSeatFromRoom(Seat seat, Room room) {
        room.getSeats().remove(seat.getId());
        seat.setRoom(null);
    }

    private Map<String, LocalDateTime> getMovieShowTimesWithTheaterId(String theaterId, String movieId) {
        Theater theater = theaters.get(theaterId);
        Map<String, LocalDateTime> movieShowTimes = theater.getTheaterSchedule().get(movieId);

        return movieShowTimes;
    }

    // methodes -> makeBooking(); (req 2) ✅
    public void makeBooking(User user) {
        try {
            getMoviesList();
            
            boolean bookingConfirmed = false;
            while (!bookingConfirmed) {
                String movieId = getValidInput(movies, "Enter movie id: ");
                Map<String, Theater> theatersList = getMovieTheatersList(movieId);

                String theaterId = getValidInput(theatersList, "Enter theater id: ");

                Map<String, LocalDateTime> showTimes = displayMovieTimes(movieId, theaterId);

                String showTime = getValidInput(showTimes, "Enter show time <YYYY-MM-DDTHH:MM> form: ");

                String roomId = showTime + "MOV_" + movieId;
                Map<String, Seat> seatList = getRoomSeatList(theaterId, roomId);

                String seatId = getValidInput(seatList, "Enter seat number: ");

                Theater theater = theaters.get(theaterId);
                Movie movie = movies.get(movieId);
                LocalDateTime showDateTime = showTimes.get(showTime);
                Seat seat = seatList.get(seatId);
                seat.setStatus(SeatStatus.BKD);
                Booking booking = new Booking(user.getId() + movie.getId(), user, theater, movie, seat, showDateTime);
                bookings.put(booking.getId(), booking);

                bookingConfirmed = true;
            }
        } finally {
            scanner.close();
        }
    }

    private Map<String, Seat> getRoomSeatList(String theaterId, String roomId) {
        Map<String, Seat> seatList = new HashMap<String, Seat>();
        Theater theater = theaters.get(theaterId);
        Room room = theater.getRoomSchadule().get(roomId);

        for (Seat seat : room.getSeats().values()) {
            if (seat.getStatus() != SeatStatus.BKD) {
                seatList.put(seat.getId(), seat);
                System.out.println("id: " + seat.getId() + " type: " + seat.getType() + " price: " + seat.getPrice());
            }
        }

        return seatList;
    }

    private Map<String, Theater> getMovieTheatersList(String movieId) {
        Map<String, Theater> theatersList = new HashMap<String, Theater>();
        System.out.println("The movie is on these theaters:");
        for (Theater theater : theaters.values()) {
            if (theater.getMovies().containsKey(movieId)) {
                System.out.println("id: " + theater.getId() + " name: " + theater.getName());
                theatersList.put(theater.getId(), theater);
            }
        }

        return theatersList;
    }

    private Map<String, LocalDateTime> displayMovieTimes(String movieId, String theaterId) {
        Theater theater = theaters.get(theaterId);
        Map<String, LocalDateTime> movieShowTimes = theater.getTheaterSchedule().get(movieId);
        for (LocalDateTime showTime : movieShowTimes.values()) {
            System.out.println("show at: " + showTime.toLocalDate().toString() + " -- " + showTime.getHour() + ":" + showTime.getMinute());
        }
        for (String showTime : movieShowTimes.keySet()) {
            System.out.println("show at id: " + showTime);
        }

        return movieShowTimes;
    }

    private <T> String getValidInput(Map<String, T> validInputMap, String message) {
        String input;
        while (true) {
            System.out.print(message);
            if (scanner.hasNextLine()) {
                input = scanner.nextLine();
                System.out.println("---------------");
                if (validInputMap.containsKey(input)) {
                    return input;
                }
            } else {
                scanner.next();
            }
            System.out.println("Invalid input! Please enter a valid id.");
        }
    }

    public void makeSeats(Room room, int normalSeats, int premium) {
        for (int seatNum = 0; seatNum < normalSeats + premium; seatNum++) {
            String key = String.valueOf(seatNum);
            Seat seat;
            if (seatNum < premium) {
                seat = new Seat(key, SeatType.PREMIUM);
            } else {
                seat = new Seat(key, SeatType.NORMAL);
            }
            addSeatToRoom(seat, room);
        }
    }
}
