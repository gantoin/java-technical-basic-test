package fr.gantoin.technical_basic_test.controller;

import fr.gantoin.technical_basic_test.entities.Product;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        return existingProducts.values().stream().toList();
    }

    @GetMapping("/products/{id}")
    public ResponseEntity<Product> getProductById(@PathVariable int id) {
        Product product = existingProducts.get(id);

        if (product == null) {
            return ResponseEntity.notFound().eTag("No such product id").build();
        }

        return ResponseEntity.ok(product);
    }

    @PostMapping("/products")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        int lastId = existingProducts.keySet().stream().max(Integer::compareTo).orElse(0);

        if (product.id() <= lastId) {
            return ResponseEntity.notFound().eTag("Wrong id").build();
        }

        existingProducts.put(product.id(), product);
        return ResponseEntity.ok(product);
    }
}
