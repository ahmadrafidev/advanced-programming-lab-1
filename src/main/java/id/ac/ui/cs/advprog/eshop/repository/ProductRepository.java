package id.ac.ui.cs.advprog.eshop.repository;
import id.ac.ui.cs.advprog.eshop.model.Product;
import java.util.List;

/**
 * Product Repository Interface
 */
public interface ProductRepository {
    Product create(Product product);
    List<Product> findAll();
    void deleteById(int productId);
    void update(Product product);
    Product findById(int productId);
}
