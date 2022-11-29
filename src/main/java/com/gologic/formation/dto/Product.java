package com.gologic.formation.dto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

/**
 * Product data class. Getters Setters needed for SnakeYaml to deserialize
 */
public class Product {

    private int id;
    private String name;
    private String company;
    private BigDecimal price;

    private Date createdDate; // TODO: implement LocalDate and conversion functions to support migrations (of Date to LocalDate)

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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public LocalDate getLocalDate() {

        // TODO: convert util.Date to time.LocalDate

        return null;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", createdDate=" + createdDate +
                '}';
    }
}
