package org.javastart.homework24.repository;

import org.javastart.homework24.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository {

    private List<Product> database;

    public ProductRepository() {
        database = new ArrayList<>();
        database.add(new Product("czekolada", 2.50));
        database.add(new Product("wafle", 8.50));
        database.add(new Product("sok jabłkowy", 1.50));
    }

    public List<Product> add(Product product) {
        database.add(product);
        return database;
    }

    public List<Product> findAll() {
        return database;
    }

    public double sum() {
        double sum = 0;
        for (int i = 0; i < database.size(); i++) {
            sum = sum + database.get(i).getPrice();
        }
        return sum;
    }
}