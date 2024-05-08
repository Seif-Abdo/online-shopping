package org.perscholas.casestudy.database.dao;

import jakarta.transaction.Transactional;
import org.perscholas.casestudy.database.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product, Long> {
    Product findById(Integer id);

    @Query("SELECT p FROM Product p WHERE LOWER(p.productCategory) LIKE LOWER(concat('%', :productCategory, '%'))")
    List<Product> findByProductCategory(String productCategory);

    @Query("SELECT p FROM Product p WHERE LOWER(p.productName) LIKE LOWER(concat('%', :productName, '%'))")
    List<Product> findByProductName(String productName);

    //Testing
    @Modifying
    @Transactional
    int deleteByProductName(String productName);
}
