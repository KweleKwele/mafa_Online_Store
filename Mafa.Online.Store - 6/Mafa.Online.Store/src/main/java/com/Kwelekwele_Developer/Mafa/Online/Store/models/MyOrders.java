package com.Kwelekwele_Developer.Mafa.Online.Store.models;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Entity
public class MyOrders {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String orderStatus;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "customer_id", referencedColumnName = "id")
    private Customer customer;
    @OneToMany
    private List<Product> productList;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id", referencedColumnName = "id")
    private Address address;
    @CreationTimestamp
    private LocalDateTime localDateTime;

    public MyOrders() {
    }

    public MyOrders(String orderStatus, Customer customer,
                    List<Product> productList, Address address, LocalDateTime localDateTime) {
        this.orderStatus = orderStatus;
        this.customer = customer;
        this.productList = productList;
        this.address = address;
        this.localDateTime = localDateTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public List<Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public LocalDateTime getLocalDateTime() {
        return localDateTime;
    }

    public void setLocalDateTime(LocalDateTime localDateTime) {
        this.localDateTime = localDateTime;
    }

    @Override
    public String toString() {
        return "MyOrders{" +
                "id=" + id +
                ", orderStatus='" + orderStatus + '\'' +
                ", customer=" + customer +
                ", productList=" + productList +
                ", address=" + address +
                ", localDateTime=" + localDateTime +
                '}';
    }
}
