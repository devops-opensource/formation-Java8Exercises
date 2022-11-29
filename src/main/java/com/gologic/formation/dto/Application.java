package com.gologic.formation.dto;

import java.util.List;

/**
 * Application data class. Getters Setters needed for SnakeYaml to deserialize
 */
public class Application {

    private String name;
    private List<Product> products;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Application{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }
}
