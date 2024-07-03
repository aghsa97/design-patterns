package com.mycompany.app.hard.movie_ticket_booking;

// methodes -> modifyMovie(); (req 7) ✅
public class Admin extends User {
    private Theater theater;

    public Admin(String id, String name, Theater theater) {
        super(id,name);
        this.theater = theater;
    }

    public Theater getTheater() {
        return theater;
    }

    public void addMovie(Movie movie) {
        theater.getMovies().put(movie.getId(), movie);
    }

    public void updateMovie(Movie movie) {
        Movie oldMovie = theater.getMovies().get(movie.getId());
        oldMovie.setName(movie.getName());
        oldMovie.setDuration(movie.getDuration());
    }

    public void deleteMovie(String movieId) {
        theater.getMovies().remove(movieId);
    }

    public void arrangeSeat(Seat seat) {
        Seat oldSeat = theater.getRooms().get(seat.getRoom().getId()).getSeats().get(seat.getId());
        oldSeat.setRoom(seat.getRoom());
        oldSeat.setStatus(seat.getStatus());
        oldSeat.setType(seat.getType());
    }
}
