package id.ac.ui.cs.advprog.eshop.model;

import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class ProductTest {

    private Product product;

    @BeforeEach
    void setUp() {
        // Initialize product; productId will be set automatically to the next integer.
        this.product = new Product();
        this.product.setProductName("Sampo Cap Bambang");
        this.product.setProductQuantity(100);
    }

    @Test
    void testProductIdIsAutoIncremented() {
        // Assuming this is the first product created in the test suite, its ID should be 1.
        // Adjust the expected value if this assumption does not hold in your test environment.
        assertEquals(1, this.product.getProductId());
    }

    @Test
    void testGetProductName() {
        assertEquals("Sampo Cap Bambang", this.product.getProductName());
    }

    @Test
    void testGetProductQuantity() {
        assertEquals(100, this.product.getProductQuantity());
    }
}
