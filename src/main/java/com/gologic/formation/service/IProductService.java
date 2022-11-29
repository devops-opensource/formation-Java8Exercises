package com.gologic.formation.service;

import com.gologic.formation.dto.Product;

import java.math.BigDecimal;

public interface IProductService {

    Iterable<Product> getAll();
    Iterable<Product> getAll(String name);
    Iterable<Product> getAll(BigDecimal minPrice, BigDecimal maxPrice);

}
