package com.example.demo.product;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {

    boolean deleteProductById(Long id);

    Optional<Product> getProductsById(Long id);

}
