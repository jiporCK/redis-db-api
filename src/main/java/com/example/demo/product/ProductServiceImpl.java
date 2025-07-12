package com.example.demo.product;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService{

    private final ProductRepository repository;

    @Override
    @CacheEvict(cacheNames = "products",
                allEntries = true)
    public boolean create(Product product) {
        if (product != null) {
            repository.save(product);
            return true;
        }
        return false;
    }

    @Override
    @Cacheable("products")
    public List<Product> getAll() {
        return repository.findAll();
    }

}
