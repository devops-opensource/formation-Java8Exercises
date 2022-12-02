package com.gologic.formation.dto;

import com.gologic.formation.annotation.Numeric;
import com.gologic.formation.annotation.Sensitive;
import com.gologic.formation.annotation.Serialize;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Product data class. Getters Setters needed for SnakeYaml to deserialize
 */
@Serialize
public class Product {

    public Product() {
    }

    public Product(int id, String name, String company, BigDecimal price) {
        this.id = id;
        this.name = name;
        this.company = company;
        this.price = price;
    }

    @Sensitive
    private @Numeric int id;
    private String name;
    private String company;
    @Sensitive
    private @Numeric BigDecimal price;

    private Date createdDate;

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

        if(createdDate == null)
            createdDate = new Date();

        return createdDate;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", createdDate=" + getCreatedDate() +
                '}';
    }
}
