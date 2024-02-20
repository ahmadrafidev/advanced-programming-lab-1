package id.ac.ui.cs.advprog.eshop.service.product;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

/**
 * Product Service Interface
 */
public interface ProductService {
    public Product create(Product product);
    public List<Product> findAll();
    void deleteProduct(String productId);
    void update(Product product);
    Product findById(String productId);
}