package com.example.demo.product;

import java.util.List;

public interface ProductService {

    boolean create(Product product);

    List<Product> getAll();

}
