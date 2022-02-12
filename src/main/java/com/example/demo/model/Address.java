package com.example.demo.model;

import java.io.IOException;

public class Address {
    private int id;
    private int houseNumber;
    private String street;
    private String city;
    private int zipcode;
    private String state;
    private boolean favourite;

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }

    public Address(int houseNumber, String street, String city, int zipcode, String state) {
        this.houseNumber = houseNumber;
        this.street = street;
        this.city = city;
        this.zipcode = zipcode;
        this.state = state;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) throws IOException {
        if (zipcode >= 00000 && zipcode <= 99999)
        {
            this.zipcode = zipcode;
        }
        else
        {
            throw new IOException("Zip code out of bounds");
        }

    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
