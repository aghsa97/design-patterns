package com.mycompany.app.hard.movie_ticket_booking;

public enum SeatType {
    NORMAL(10),
    PREMIUM(15);

    private final int price;

    private SeatType(int price) {
        this.price = price;
    }

    public int getPrice() {
        return price;
    }
}
