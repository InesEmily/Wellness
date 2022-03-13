package com.wellness.wellness.model;

import java.sql.Time;
import java.util.Date;

public class Booking {
    private Client client;
    private Date date;
    private Time time;

    public Booking() {
    }

    public Booking(Client client, Date date, Time time) {
        this.client = client;
        this.date = date;
        this.time = time;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }
}
