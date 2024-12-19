package com.iths.controller;

import com.iths.domain.pojo.Product;
import com.iths.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/search")
    public List<Product> searchProducts(
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String category,
            @RequestParam(defaultValue = "asc") String sortOrder) {
        return productService.searchProducts(name, category, sortOrder);
    }


    /**
     * 添加产品
     */
    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return productService.addProduct(product);
    }


    /**
     * 更新产品
     */
    @PutMapping
    public Product updateProduct(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

    /**
     * 删除产品
     */
    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        productService.deleteProduct(id);
    }

    /**
     * 根据 ID 查询产品
     */
    @GetMapping(params = "id")
    public Product findProductByIdWithParam(@RequestParam int id) {
        return productService.findProductById(id);
    }

    /**
     * 查询所有产品
     */
    @GetMapping
    public List<Product> findAllProducts() {
        return productService.findAllProducts();
    }

}
