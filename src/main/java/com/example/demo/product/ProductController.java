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

    @PostMapping
    public ResponseEntity<?> createProduct(@RequestBody Product product) {
        if (productService.create(product)) {
            return ResponseEntity.status(HttpStatus.CREATED).body(product);
        }
        return ResponseEntity.badRequest().body("Invalid product or failed to save");
    }
}

