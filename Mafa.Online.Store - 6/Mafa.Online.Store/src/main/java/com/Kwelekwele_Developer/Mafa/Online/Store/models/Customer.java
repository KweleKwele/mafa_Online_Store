package com.Kwelekwele_Developer.Mafa.Online.Store.models;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String surname;
    private Long cellNumber;
    private String email;
    private String username;

    private String password;
    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Address> addressList = new ArrayList<>();

    //Constructors
    public Customer() {
    }

    public Customer(String name, String surname, Long cellNumber,
                    String email, String username, String password, List<Address> addressList) {
        this.name = name;
        this.surname = surname;
        this.cellNumber = cellNumber;
        this.email = email;
        this.username = username;
        this.password = password;
        this.addressList = addressList;
    }

    //setters and getters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Long getCellNumber() {
        return cellNumber;
    }

    public void setCellNumber(Long cellNumber) {
        this.cellNumber = cellNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Address> getAddressList() {
        return addressList;
    }

    public void setAddressList(List<Address> addressList) {
        this.addressList = addressList;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", cellNumber=" + cellNumber +
                ", email='" + email + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", addressList=" + addressList +
                '}';
    }
}
