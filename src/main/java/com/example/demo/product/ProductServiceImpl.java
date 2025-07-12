package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Override
    @CacheEvict(cacheNames = "products", allEntries = true)
    public boolean create(Product product) {
        if (product != null) {
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    @CacheEvict(cacheNames = "products", allEntries = true)
    public boolean delete(Long id) {
        return repository.deleteProductById(id);
    }

    @Override
    @CacheEvict(cacheNames = "products", allEntries = true)
    public boolean updateById(Long id, Product product) {
        Product existProduct = repository.getProductsById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product has not been found"
                        )
                );

        if (existProduct != null) {
            existProduct.setName(product.getName());
            existProduct.setPrice(product.getPrice());
            existProduct.setQty(product.getQty());
            existProduct.setUpdatedAt(LocalDateTime.now());

            repository.save(existProduct);

            return true;
        }

        return false;
    }

    @Override
    @Cacheable("products")
    public List<Product> getAll() {
        return repository.findAll();
    }

    @Override
    public Product getById(Long id) {
        return repository.getProductsById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(
                                HttpStatus.NOT_FOUND,
                                "Product has not been found"
                        )
                );
    }
}
