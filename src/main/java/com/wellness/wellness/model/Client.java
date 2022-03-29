package com.wellness.wellness.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
public class Client {
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "client_generator")
    @SequenceGenerator(name = "client_generator",sequenceName = "client_seq",allocationSize = 1)
    @Id
    private Integer id;
    private String name;
    private String lastName;
    private String gender;
    private LocalDate birthday;
    private int phoneNumber;
    private String street;
    private int housenumber;
    private int postalcode;
    private String email;

    public Client() {
    }

    public Client(String name, String lastName, String gender, LocalDate birthday, int phoneNumber, String street, int housenumber, int province, String email) {
        this.name = name;
        this.lastName = lastName;
        this.gender = gender;
        this.birthday = birthday;
        this.phoneNumber = phoneNumber;
        this.street = street;
        this.housenumber = housenumber;
        this.postalcode = province;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getHousenumber() {
        return housenumber;
    }

    public void setHousenumber(int housenumber) {
        this.housenumber = housenumber;
    }

    public int getPostalcode() {
        return postalcode;
    }

    public void setPostalcode(int province) {
        this.postalcode = province;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @ManyToMany(mappedBy = "clients")
    private Collection<Personnel> personnels;

    public Collection<Personnel> getPersonnels() {
        return personnels;
    }

    public void setPersonnels(Collection<Personnel> personnels) {
        this.personnels = personnels;
    }
}
