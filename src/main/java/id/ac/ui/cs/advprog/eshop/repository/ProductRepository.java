package id.ac.ui.cs.advprog.eshop.repository;

import org.springframework.stereotype.Repository;
import id.ac.ui.cs.advprog.eshop.model.Product;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Repository
public class ProductRepository {
    private List<Product> productData = new ArrayList<>();

    public Product create(Product product){
        productData.add(product);
        return product;
    }

    public Iterator<Product> findAll(){
        return productData.iterator();
    } 

    public void deleteById(String productId) {
        try {
            int id = Integer.parseInt(productId);
            productData.removeIf(product -> product.getProductId() == id);
        } catch (NumberFormatException e) {
            System.err.println("Error parsing productId: " + productId);
        }
    }    

    public void update(Product updatedProduct) {
        for (int i = 0; i < productData.size(); i++) {
            Product product = productData.get(i);
            if (product.getProductId() == updatedProduct.getProductId()) {
                productData.set(i, updatedProduct);
                break; // Exit the loop once the product is found and updated
            }
        }
    }

    public Product findById(int productId) {
        for (Product product : productData) {
            if (product.getProductId() == productId) {
                return product; 
            }
        }
        return null; 
    }    
    
    
}
