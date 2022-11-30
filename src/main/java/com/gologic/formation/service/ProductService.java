package com.gologic.formation.service;

import com.gologic.formation.dto.Application;
import com.gologic.formation.dto.Product;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService {

    private static final Logger LOG = LogManager.getLogger(ProductService.class);

    private Application application;

    public ProductService(Application application) {
        this.application = application;
    }

    @Override
    public Iterable<Product> getAll() {

        List<Product> products = application.getProducts();

        LOG.debug(String.format("Returning %d products", products.size()));
        return products;
    }

    @Override
    public Iterable<Product> getAll(String name) {

        List<Product> foundProducts = new ArrayList<>();

        // TODO: Rewrite using lambdas stream functions and Optional

        for(Product p : application.getProducts()) {

            if(p.getName().equalsIgnoreCase(name)) {
                foundProducts.add(p);
                LOG.debug(String.format("Found matching product %s", p));
            }
        }

        LOG.debug(String.format("Returning %d products", foundProducts.size()));
        return foundProducts;
    }

    @Override
    public Iterable<Product> getAll(BigDecimal minPrice, BigDecimal maxPrice) {

        List<Product> foundProducts = new ArrayList<>();

        // TODO: Rewrite using lambdas streams and a predicate for the comparison

        for(Product p : application.getProducts()) {
            if(p.getPrice().compareTo(minPrice) >= 0 && p.getPrice().compareTo(maxPrice) <= 0) {
                foundProducts.add(p);
                LOG.debug(String.format("Found matching product %s", p));
            }
        }

        LOG.debug(String.format("Returning %d products", foundProducts.size()));
        return foundProducts;
    }

    // TODO: Introduce new methods to return list sorted by price, name, descending order
}
