package com.gologic.formation.service;

import com.gologic.formation.dto.Product;

import java.math.BigDecimal;

public interface IProductService {

    /**
     * Get all products
     */
    Iterable<Product> getAll();

    /**
     * Get all products matching the name (case-insensitive)
     */
    Iterable<Product> getAll(String name);

    /**
     * Get all products that its price is between min (inclusive) and max (inclusive)
     */
    Iterable<Product> getAll(BigDecimal minPrice, BigDecimal maxPrice);

    // TODO: introduce default method to output anything..
}
