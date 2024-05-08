package org.perscholas.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ProductService {
    @Autowired
    private ProductDAO productDao;

    public Product createProduct(CreateProductFormBean form) {
        log.debug("id" + form.getId());
        log.debug("product name: " + form.getProductName());
        log.debug("description: " + form.getProductDescription());
        log.debug("MSRP: " + form.getProductMSRP());
        log.debug("imageUrl: " + form.getImageUrl());
        log.debug("description: " + form.getProductDescription());

        Product product = productDao.findById(form.getId());

        if (product == null) {
            product = new Product();
        }

        product.setProductName(form.getProductName());
        product.setProductDescription(form.getProductDescription());
        product.setProductMSRP(form.getProductMSRP());
        product.setImageUrl(form.getImageUrl());
        product.setProductCategory(form.getProductCategory());

        return productDao.save(product);
    }
}
