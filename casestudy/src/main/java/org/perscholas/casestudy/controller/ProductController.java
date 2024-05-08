package org.perscholas.casestudy.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.formbean.CreateProductFormBean;
import org.perscholas.casestudy.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Slf4j
@Controller
public class ProductController {
    @Autowired
    private ProductDAO productDao;

    @Autowired
    private ProductService productService;

    @GetMapping("/product/search")
    public ModelAndView search(@RequestParam String productName) {
        ModelAndView response = new ModelAndView("product/search");

        log.debug("In the product search controller method : search parameter = " + productName);

        if (productName != null) {
            List<Product> products = productDao.findByProductCategory(productName);

            if (products.isEmpty()) {
                products = productDao.findByProductName(productName);
            }

            response.addObject("products", products);
            response.addObject("productSearch", productName);

            for(Product product: products){
                log.debug("Product : " + product.getId() + " " + product.getProductName() + " " + product.getProductCategory());
            }
        }

        return response;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/product/create")
    public ModelAndView createProduct() {
        ModelAndView response = new ModelAndView("product/create");

        log.debug("In create product with no args");

        return response;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/product/edit/{id}")
    public ModelAndView editProduct(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product/create");

        Product product = productDao.findById(id);

        CreateProductFormBean form = new CreateProductFormBean();

        if (product != null) {
            form.setId(product.getId());
            form.setProductName(product.getProductName());
            form.setProductDescription(product.getProductDescription());
            form.setProductMSRP(product.getProductMSRP());
            form.setImageUrl(product.getImageUrl());
            form.setProductCategory(product.getProductCategory());

        } else {
            log.warn("Product with id " + id + " was not be found!");
        }

        response.addObject("form", form);

        return response;
    }

    @PreAuthorize("hasAnyAuthority('ADMIN')")
    @GetMapping("/product/createSubmit")
    public ModelAndView createProductSubmit(@Valid CreateProductFormBean form, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            log.info("######################### In create product submit - has errors #########################");
            ModelAndView response = new ModelAndView("product/create");

            for (ObjectError error : bindingResult.getAllErrors()) {
                log.info("error: " + error.getDefaultMessage());
            }

            response.addObject("form", form);
            response.addObject("errors", bindingResult);
            return response;
        }

        log.info("######################### In create customer submit - no error found #########################");

        Product p = productService.createProduct(form);
        ModelAndView response = new ModelAndView("redirect:/product/detail/" + p.getId());

        return response;
    }

    @GetMapping("/product/detail/{id}")
    public ModelAndView detailProduct(@PathVariable Integer id) {
        ModelAndView response = new ModelAndView("product/detail");

        Product product = productDao.findById(id);

        CreateProductFormBean form = new CreateProductFormBean();

        if (product != null) {
            form.setId(product.getId());
            form.setProductName(product.getProductName());
            form.setProductDescription(product.getProductDescription());
            form.setProductMSRP(product.getProductMSRP());
            form.setImageUrl(product.getImageUrl());
            form.setProductCategory(product.getProductCategory());

        } else {
            log.warn("Product with id " + id + " was not be found!");
        }

        response.addObject("product", form);

        return response;
    }
}
