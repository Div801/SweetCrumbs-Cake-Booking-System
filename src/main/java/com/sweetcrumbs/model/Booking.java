
package com.sweetcrumbs.model;

public class Booking {

    private int bookingId;
    private int customerId;
    private String cakeName;
    private String cakeSize;
    private String eventDate;
    private String message;

    public Booking(int bookingId, int customerId,
                   String cakeName, String cakeSize,
                   String eventDate, String message) {
        this.bookingId = bookingId;
        this.customerId = customerId;
        this.cakeName = cakeName;
        this.cakeSize = cakeSize;
        this.eventDate = eventDate;
        this.message = message;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getCakeName() {
        return cakeName;
    }

    public void setCakeName(String cakeName) {
        this.cakeName = cakeName;
    }

    public String getCakeSize() {
        return cakeSize;
    }

    public void setCakeSize(String cakeSize) {
        this.cakeSize = cakeSize;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

