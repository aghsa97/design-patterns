package com.mycompany.app.hard.ride_sharing_service;

public class Driver extends User {
    private DriverStatus status;

    public enum DriverStatus {
        AVAILABLE,
        BUSY
    }

    public Driver(String id, String name) {
        super(id, name);
        this.status = DriverStatus.AVAILABLE;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }
}
