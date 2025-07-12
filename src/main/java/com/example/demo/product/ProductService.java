package com.example.demo.product;

import java.util.List;

public interface ProductService {

    boolean create(Product product);

    boolean delete(Long id);

    boolean updateById(Long id, Product product);

    List<Product> getAll();

    Product getById(Long id);

}
