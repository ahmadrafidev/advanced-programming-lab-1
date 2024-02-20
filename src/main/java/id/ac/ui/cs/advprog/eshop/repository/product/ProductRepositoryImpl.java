package id.ac.ui.cs.advprog.eshop.repository.product;
import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.List;

/**
 * Product Repository Implementation
 */
@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private final List<Product> productData = new ArrayList<>();

    @Override
    public Product create(Product product) {
        productData.add(product);
        return product;
    }

    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productData);
    }

    @Override
    public void deleteById(int productId) {
        productData.removeIf(product -> product.getProductId() == productId);
    }

    @Override
    public void update(Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product product = productData.get(i);
            if (product.getProductId() == updatedProduct.getProductId()) {
                productData.set(i, updatedProduct);
                break;
            }
        }
    }

    @Override
    public Product findById(int productId) {
        for (Product product : productData) {
            if (product.getProductId() == productId) {
                return product;
            }
        }
        return null;
    }
}
