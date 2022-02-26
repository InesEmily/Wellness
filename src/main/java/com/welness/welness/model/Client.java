package com.welness.welness.model;

import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {
    @Id
    private int id;
    private String name;
    private String lastName;
    private Character gender;
    private String birthday;
    private int phoneNumber;
    private String adres;
    private String email;

    public Client() {
    }

    public Client(String name, String lastName,Character gender, String birthday, int phoneNumber, String adres, String email) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.adres = adres;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getBirthday() {
        return birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public String getAdres() {
        return adres;
    }

    public String getEmail() {
        return email;
    }

    public Character getGender() {
        return gender;
    }
}
