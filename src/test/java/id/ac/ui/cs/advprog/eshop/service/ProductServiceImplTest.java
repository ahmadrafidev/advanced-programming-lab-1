package id.ac.ui.cs.advprog.eshop.service;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.repository.ProductRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductServiceImplTest {

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductServiceImpl productService;

    private Product testProduct;

    @BeforeEach
    void setUp() {
        testProduct = new Product();
        testProduct.setProductName("Test Product");
        testProduct.setProductQuantity(10);
        // Assuming we set the product ID after creation for testing purposes
        // Normally, this would be handled by the repository or database in a real application
        testProduct.setProductId(1);
    }

    @Test
    void testCreateProduct() {
        when(productRepository.create(any(Product.class))).thenReturn(testProduct);

        Product createdProduct = productService.create(testProduct);
        assertNotNull(createdProduct);
        assertEquals(testProduct.getProductName(), createdProduct.getProductName());

        verify(productRepository).create(any(Product.class));
    }

    @Test
    void testFindAllProducts() {
        when(productRepository.findAll()).thenReturn(Collections.singletonList(testProduct));

        List<Product> products = productService.findAll();
        assertFalse(products.isEmpty());
        assertEquals(1, products.size());
        assertEquals(testProduct, products.get(0));

        verify(productRepository).findAll();
    }

    @Test
    void testFindById() {
        when(productRepository.findById(anyInt())).thenReturn(testProduct);

        Product foundProduct = productService.findById("1");
        assertNotNull(foundProduct);
        assertEquals(testProduct.getProductId(), foundProduct.getProductId());

        verify(productRepository).findById(anyInt());
    }

    @Test
    void testUpdateProduct() {
        doNothing().when(productRepository).update(any(Product.class));

        assertDoesNotThrow(() -> productService.update(testProduct));
        verify(productRepository).update(any(Product.class));
    }

    @Test
    void testDeleteProductById() {
        doNothing().when(productRepository).deleteById(anyInt());

        assertDoesNotThrow(() -> productService.deleteProduct("1"));
        verify(productRepository).deleteById(anyInt());
    }

    @Test
    void testCreateProductWithNull() {
        assertThrows(IllegalArgumentException.class, () -> productService.create(null));
    }

    @Test
    void testDeleteProductWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> productService.deleteProduct(null));
        assertThrows(IllegalArgumentException.class, () -> productService.deleteProduct(""));
        assertThrows(NumberFormatException.class, () -> productService.deleteProduct("invalid"));
    }

    @Test
    void testFindByIdWithInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> productService.findById(null));
        assertThrows(IllegalArgumentException.class, () -> productService.findById(""));
        assertThrows(NumberFormatException.class, () -> productService.findById("invalid"));
    }

    @Test
    void testUpdateProductWithNull() {
        assertThrows(IllegalArgumentException.class, () -> productService.update(null));
    }
}
