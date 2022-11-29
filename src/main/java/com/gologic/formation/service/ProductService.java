package com.gologic.formation.service;

import com.gologic.formation.dto.Application;
import com.gologic.formation.dto.Product;

import java.math.BigDecimal;

public class ProductService implements IProductService {

    private Application application;

    public ProductService(Application application) {
        this.application = application;
    }

    // TODO: implement using Java 7 loops (no streams)
    // TODO: introduce optional for parametrized searches
    // TODO: introduce predicates for sorting. Find other examples of Predicates

    @Override
    public Iterable<Product> getAll() {
        return null;
    }

    @Override
    public Iterable<Product> getAll(String name) {
        return null;
    }

    @Override
    public Iterable<Product> getAll(BigDecimal minPrice, BigDecimal maxPrice) {
        return null;
    }
}
