package com.wellness.wellness.model;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Booking {
    @Id
    private int id;
    @ManyToOne
    private Client client;
    @ManyToOne
    private Room room;
    @Temporal(TemporalType.DATE)
    private Date date;
    @Temporal(TemporalType.TIME)
    private Date time;

    public Booking() {
    }

    public Booking(Client client, Room room, Date date, Date time) {
        this.client = client;
        this.room = room;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
