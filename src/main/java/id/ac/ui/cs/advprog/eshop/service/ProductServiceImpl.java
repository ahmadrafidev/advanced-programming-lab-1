package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product create(Product product) {
        // Ensure product is not null before creating
        if (product == null) {
            // Optionally throw an IllegalArgumentException or return null
            throw new IllegalArgumentException("Product cannot be null");
        }
        productRepository.create(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        Iterator<Product> productIterator = productRepository.findAll();
        if (productIterator == null) {
            return new ArrayList<>(); // Return an empty list if the iterator is null
        }
        List<Product> allProduct = new ArrayList<>();
        productIterator.forEachRemaining(allProduct::add);
        return allProduct;
    }

    @Override
    public void deleteProduct(String productId) {
        // Validate productId is not null and not empty
        if (productId == null || productId.trim().isEmpty()) {
            // Log error, throw exception, or handle accordingly
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        try {
            productRepository.deleteById(productId);
        } catch (NumberFormatException e) {
            // Log the error or throw a custom exception
            throw new IllegalArgumentException("Product ID must be a valid integer");
        }
    }

    @Override
    public void update(Product product) {
        productRepository.update(product);
    }

    @Override
    public Product findById(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            // Return null, log error, or throw exception
            throw new IllegalArgumentException("Product ID cannot be null or empty");
        }
        try {
            int id = Integer.parseInt(productId);
            return productRepository.findById(id);
        } catch (NumberFormatException e) {
            // Log the error or throw a custom exception
            throw new IllegalArgumentException("Product ID must be a valid integer", e);
        }
    }

}
