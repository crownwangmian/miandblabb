package com.iths;


import com.iths.controller.ProductController;
import com.iths.domain.pojo.Product;
import com.iths.service.ProductService;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class MiandatabaseLabbApplicationTests {
    @InjectMocks
    private ProductController productController;

    @Mock
    private ProductService productService;

    public MiandatabaseLabbApplicationTests() {
        MockitoAnnotations.openMocks(this);
    }

//    @Test
//    public void testSearchProductsByName() {
//        Product product1 = new Product();
//        product1.setName("apple");
//        product1.setCategory("Electronics");
//        product1.setPrice(900);
//        when(productService.searchProducts("apple", null, "asc"))
//                .thenReturn(Arrays.asList(product1));
//
//        List<Product> result = productController.searchProducts("apple", null, "asc");
//
//        assertEquals(1, result.size());
//        assertEquals("apple", result.get(0).getName());
//        verify(productService, times(1)).searchProducts("apple", null, "asc");
//    }

//    @Test
//    public void testSearchProductsByCategory() {
//        // Mock data
//        Product product1 = new Product();
//        product1.setName("apple");
//        product1.setCategory("Electronics");
//        product1.setPrice(900);
//        Product product2 = new Product();
//        product2.setName("xiaomi");
//        product2.setCategory("Electronics");
//        product2.setPrice(386.36);
//        when(productService.searchProducts(null, "Electronics", "desc"))
//                .thenReturn(Arrays.asList(product2, product1));
//
//        List<Product> result = productController.searchProducts(null, "Electronics", "desc");
//
//        assertEquals(2, result.size());
//        assertEquals("xiaomi", result.get(0).getName());
//        verify(productService, times(1)).searchProducts(null, "Electronics", "desc");
//    }

}
