package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class ProductRepositoryImplTest {

    private ProductRepositoryImpl productRepository;
    private Product testProduct;

    @BeforeEach
    void setUp() {
        // Initialize the repository
        productRepository = new ProductRepositoryImpl();

        // Create a test product and add it to the repository
        testProduct = new Product();
        testProduct.setProductName("Test Product");
        testProduct.setProductQuantity(10);
        productRepository.create(testProduct);
    }

    @Test
    void testCreateProduct() {
        // Verify the product was added
        Product foundProduct = productRepository.findById(testProduct.getProductId());
        assertNotNull(foundProduct);
        assertEquals("Test Product", foundProduct.getProductName());
        assertEquals(10, foundProduct.getProductQuantity());
    }

    @Test
    void testFindAllProducts() {
        List<Product> products = productRepository.findAll();
        assertFalse(products.isEmpty());
        assertTrue(products.contains(testProduct));
    }

    @Test
    void testDeleteById() {
        // Delete the test product
        productRepository.deleteById(testProduct.getProductId());
        Product foundProduct = productRepository.findById(testProduct.getProductId());
        assertNull(foundProduct);
    }

    @Test
    void testUpdateProduct() {
        // Create an updated product (same ID, different details)
        Product updatedProduct = new Product();
        updatedProduct.setProductId(testProduct.getProductId()); // Assuming we can set the ID for testing
        updatedProduct.setProductName("Updated Product");
        updatedProduct.setProductQuantity(20);

        productRepository.update(updatedProduct);

        // Verify the update took place
        Product foundProduct = productRepository.findById(testProduct.getProductId());
        assertNotNull(foundProduct);
        assertEquals("Updated Product", foundProduct.getProductName());
        assertEquals(20, foundProduct.getProductQuantity());
    }

    @Test
    void testFindById() {
        Product foundProduct = productRepository.findById(testProduct.getProductId());
        assertNotNull(foundProduct);
        assertEquals(testProduct.getProductId(), foundProduct.getProductId());
    }
}
