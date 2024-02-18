package id.ac.ui.cs.advprog.eshop.model;
import lombok.Getter;
import lombok.Setter;

/**
 * Product Model
 */
@Getter @Setter
public class Product {
    private static int lastId = 0;

    private int productId;
    private String productName;
    private int productQuantity;

    // Constructor
    public Product() {
        this.productId = ++lastId;
    }
}
