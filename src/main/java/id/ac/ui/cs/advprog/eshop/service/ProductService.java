package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.List;

/**
 * ProductService
 */
public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    void deleteProduct(String productId);
}