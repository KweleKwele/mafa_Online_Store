package com.Kwelekwele_Developer.Mafa.Online.Store.models;

import jakarta.persistence.*;
import jdk.jfr.Category;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String productName;
    private String color;
    private double price;
    private int quantity;
    private String specification;
    private String dimension ;
    private String manufacture;
    @Enumerated(EnumType.STRING)
    private CategoryEnum category;

    public Product() {
    }

    public Product(String productName, String color, double price, int quantity,
                   String specification, String dimension, String manufacture, CategoryEnum category) {
        this.productName = productName;
        this.color = color;
        this.price = price;
        this.quantity = quantity;
        this.specification = specification;
        this.dimension = dimension;
        this.manufacture = manufacture;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getSpecification() {
        return specification;
    }

    public void setSpecification(String specification) {
        this.specification = specification;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public CategoryEnum getCategory() {
        return category;
    }

    public void setCategory(CategoryEnum category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", color='" + color + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", specification='" + specification + '\'' +
                ", dimension='" + dimension + '\'' +
                ", manufacture='" + manufacture + '\'' +
                ", category=" + category +
                '}';
    }
}
