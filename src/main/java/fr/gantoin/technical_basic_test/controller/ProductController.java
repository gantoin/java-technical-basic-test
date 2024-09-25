package fr.gantoin.technical_basic_test.controller;

import fr.gantoin.technical_basic_test.entities.Product;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ProductController {

    // We use a map to store the products, the key is the id of the product
    private Map<Integer, Product> existingProducts = initProducts();

    public Map<Integer, Product> existingProducts() {
        return existingProducts;
    }

    public ProductController setExistingProducts(Map<Integer, Product> existingProducts) {
        this.existingProducts = existingProducts;
        return this;
    }

    public ProductController() {
    }

    private Map<Integer, Product> initProducts() {
        this.existingProducts = new HashMap<>();
        // We init some existing products for the test
        Product product1 = new Product(1, "Product 1", "Description of product 1", 10.0);
        Product product2 = new Product(2, "Product 2", "Description of product 2", 20.0);
        Product product3 = new Product(3, "Product 3", "Description of product 3", 30.0);
        existingProducts.put(1, product1);
        existingProducts.put(2, product2);
        existingProducts.put(3, product3);
        return existingProducts;
    }

    @GetMapping("/products")
    public List<Product> getProducts() {
        // TODO: Convert the map to a list and return it
        return existingProducts;
    }

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable int id) {
        //TODO: Implement the method to return the product with the given id
        return null;
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        // TODO: Implement the method to add a new product and return it
        return null;
    }
}
