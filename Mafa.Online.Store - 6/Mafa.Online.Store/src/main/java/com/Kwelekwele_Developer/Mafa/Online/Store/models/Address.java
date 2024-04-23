package com.Kwelekwele_Developer.Mafa.Online.Store.models;

import jakarta.persistence.*;

import java.util.Optional;

@Entity
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String province;
    private String city;
    private String lineOne;
    private String lineTwo;
    private String streetNo;
    private int postalCode;
    @ManyToOne
    @JoinColumn(name = "customer_Id")
    private Customer customer;

    //constructors
    public Address() {
    }

    public Address(String province, String city, String lineOne, String lineTwo, String streetNo, int postalCode, Customer customer) {
        this.province = province;
        this.city = city;
        this.lineOne = lineOne;
        this.lineTwo = lineTwo;
        this.streetNo = streetNo;
        this.postalCode = postalCode;
        this.customer = customer;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getLineOne() {
        return lineOne;
    }

    public void setLineOne(String lineOne) {
        this.lineOne = lineOne;
    }

    public String getLineTwo() {
        return lineTwo;
    }

    public void setLineTwo(String lineTwo) {
        this.lineTwo = lineTwo;
    }

    public String getStreetNo() {
        return streetNo;
    }

    public void setStreetNo(String streetNo) {
        this.streetNo = streetNo;
    }

    public int getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(int postalCode) {
        this.postalCode = postalCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", province='" + province + '\'' +
                ", city='" + city + '\'' +
                ", lineOne='" + lineOne + '\'' +
                ", lineTwo='" + lineTwo + '\'' +
                ", streetNo='" + streetNo + '\'' +
                ", postalCode=" + postalCode +
                ", customer=" + customer +
                '}';
    }
}