package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class ProductDAOTest {
    @Autowired
    private ProductDAO productDAO;

    @Test
    @Order(1)
    public void createProductTest() {
        //Given
        Product product = new Product();
        product.setProductName("Test Product");
        product.setProductDescription("Test Product Description");
        product.setProductMSRP(BigDecimal.valueOf(919.09));
        product.setImageUrl("Test Image URL");
        product.setProductCategory("Test Category");

        //When
        product = productDAO.save(product);

        //Then
        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Product", product.getProductName());
        Assertions.assertEquals("Test Product Description", product.getProductDescription());
        Assertions.assertEquals(BigDecimal.valueOf(919.09), product.getProductMSRP());
        Assertions.assertEquals("Test Image URL", product.getImageUrl());
        Assertions.assertEquals("Test Category", product.getProductCategory());
    }

    @Test
    @Order(2)
    public void findByProductNameTest() {
        //Given
        String productName = "Test Product";

        //When
        Product product = productDAO.findByProductName(productName).get(0);

        //Then
        Assertions.assertEquals(1, productDAO.findByProductName(productName).size());

        Assertions.assertNotNull(product.getId());
        Assertions.assertEquals("Test Product", product.getProductName());
        Assertions.assertEquals("Test Product Description", product.getProductDescription());
        Assertions.assertEquals(BigDecimal.valueOf(919.09), product.getProductMSRP());
        Assertions.assertEquals("Test Image URL", product.getImageUrl());
        Assertions.assertEquals("Test Category", product.getProductCategory());
    }
    @Test
    @Order(3)
    public void deleteProductTest() {
        //Given
        String productName = "Test Product";

        //When
        int deleted = productDAO.deleteByProductName(productName);

        //Then
        Assertions.assertEquals(1,deleted);
    }
}
