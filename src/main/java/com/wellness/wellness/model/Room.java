package com.wellness.wellness.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Room {
    @Id
    private Integer id;
    private String name;
    private String description;
    private Integer capacity;

    public Room() {
    }

    public Room(String name, String description, Integer capacity) {
        this.name = name;
        this.description = description;
        this.capacity = capacity;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public Integer getCapacity() {
        return capacity;
    }
}
