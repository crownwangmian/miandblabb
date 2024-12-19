package com.iths.service;

import com.iths.domain.pojo.Product;

import java.util.List;

public interface ProductService {
    Product addProduct(Product product);

    Product updateProduct(Product product);

    void deleteProduct(int id);

    Product findProductById(int id);

    List<Product> findAllProducts();

    List<Product> searchProducts(String name, String category, String sortOrder);

}
