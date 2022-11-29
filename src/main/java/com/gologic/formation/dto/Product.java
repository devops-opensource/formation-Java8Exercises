package com.gologic.formation.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Our Product DTO (Data Transfer Object) that is used throughout the exercises
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
}
