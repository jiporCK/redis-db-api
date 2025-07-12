package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id) {
        return productService.getById(id);
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {

        return ResponseEntity.status(HttpStatus.CREATED).body(
                productService.create(product)
                        ? "Product has been created"
                        : "Failed to create product"
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProductById(@PathVariable Long id) {

        return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                productService.delete(id)
                        ? "Product has been deleted"
                        : "Failed to delete product"
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProductById(@PathVariable Long id,
                                               @RequestBody Product product) {

        return ResponseEntity.status(HttpStatus.ACCEPTED).body(
                productService.updateById(id, product)
                        ? "Product has been updated"
                        : "Failed to update product"
        );
    }

}

