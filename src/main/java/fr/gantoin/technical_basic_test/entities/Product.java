package fr.gantoin.technical_basic_test.entities;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)
public class Product {

    private int id;
    private String name;
    private String description;
    private double price;

    public Product(int id, String name, String description, double price) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
    }

    public Product() {
    }

    public int id() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String name() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String description() {
        return description;
    }

    public Product setDescription(String description) {
        this.description = description;
        return this;
    }

    public double price() {
        return price;
    }

    public Product setPrice(double price) {
        this.price = price;
        return this;
    }
}
