package com.mycompany.app.hard.movie_ticket_booking;

public class Seat {
    private final String id;
    private final int price;
    private SeatType type;
    private SeatStatus status;
    private Room room;

    public Seat(String id, SeatType type) {
        this.id = id;
        this.type = type;
        this.price = type.getPrice();
        status = SeatStatus.AVLBL;
    }

    public String getId() {
        return id;
    }

    public int getPrice() {
        return price;
    }

    public SeatType getType() {
        return type;
    }

    public Room getRoom() {
        return room;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setType(SeatType type) {
        this.type = type;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
