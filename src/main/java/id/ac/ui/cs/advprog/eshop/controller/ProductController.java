package id.ac.ui.cs.advprog.eshop.controller;
import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Product Controller
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    private static final String REDIRECT_LIST_PRODUCT = "redirect:list";

    @Autowired
    private ProductService service;

    @GetMapping("/create")
    public String createProductPage(Model model) {
        Product product = new Product();
        model.addAttribute("product", product);
        return "createProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product, Model model) {
        service.create(product);
        return REDIRECT_LIST_PRODUCT;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts);
        return "productList";
    }

    @PostMapping("/delete")
    public String deleteProduct(@RequestParam("productId") String productIdStr) {
        int productId = Integer.parseInt(productIdStr); // Convert productId to int.
        service.deleteProduct(Integer.toString(productId)); // Convert back to String.
        return REDIRECT_LIST_PRODUCT;
    }

    @GetMapping("/edit/{productId}")
    public String editProductPage(@PathVariable String productId, Model model) {
        Product product = service.findById(productId);
        if (product != null) {
            model.addAttribute("product", product);
            return "editProduct"; 
        } else {
            return "redirect:/product/list"; 
        }
    }

    @PostMapping("/update")
    public String updateProduct(@ModelAttribute Product product) {
        service.update(product);
        return "redirect:/product/list"; 
    }

}
