package com.iths.service.impl;

import com.iths.DAO.ProductDAO;
import com.iths.domain.pojo.Product;
import com.iths.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductDAO productDAO;

    @Override
    public List<Product> searchProducts(String name, String category, String sortOrder) {
        return productDAO.findProducts(name, category, sortOrder);
    }

    @Override
    public Product addProduct(Product product) {
        return productDAO.save(product);
    }

    @Override
    public Product updateProduct(Product product) {
        return productDAO.save(product);
    }

    @Override
    public void deleteProduct(int id) {
        productDAO.deleteById(id);
    }

    @Override
    public Product findProductById(int id) {
        Optional<Product> product = productDAO.findById(id);
        return product.orElse(null);
    }

    @Override
    public List<Product> findAllProducts() {
        return productDAO.findAll();
    }

}
