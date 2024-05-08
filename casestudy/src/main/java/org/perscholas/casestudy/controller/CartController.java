package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDAO;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.perscholas.casestudy.database.dao.ProductDAO;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.OrderDetail;
import org.perscholas.casestudy.database.entity.Product;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.sql.Date;
import java.util.List;

@Slf4j
@Controller
@PreAuthorize("hasAnyAuthority('USER', 'ADMIN')")
public class CartController {
    @Autowired
    ProductDAO productDAO;

    @Autowired
    OrderDetailDAO orderDetailDAO;

    @Autowired
    OrderDAO orderDAO;

    @Autowired
    AuthenticatedUserService authenticatedUserService;

    @GetMapping("/cart/addItem")
    public String addToCart(@RequestParam Integer productId) {
        User user = authenticatedUserService.loadCurrentUser();

        Product product = productDAO.findById(productId);
        log.debug("In add to cart controller method with productId = " + product.getId() + " and email = " + user.getEmail());

        Order order = orderDAO.findByUser(user.getId());

        if(order == null) {
            log.debug("Creating new order for user " + user.getEmail());
            order = new Order();
            order.setUser(user);
            order.setOrderDate(new Date(System.currentTimeMillis()));
            order.setShippingAddress(user.getAddress() + " " + user.getCity() + ", " + user.getState() + " " + user.getZipCode());
            order.setStatus("CART");
            orderDAO.save(order);
        } else {
            log.debug("Found existing order for user " + user.getEmail());
        }

        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(order.getId(), productId);

        if(orderDetail == null) {
            log.debug("Creating new order detail for order " + order.getId() + " and product " + product.getId());
            orderDetail = new OrderDetail();
            orderDetail.setOrder(order);
            orderDetail.setProduct(product);
            orderDetail.setQuantity(1);
            orderDetailDAO.save(orderDetail);
        } else {
            log.debug("Found existing order detail for order " + order.getId() + " and product " + product.getId());
            orderDetail.setQuantity(orderDetail.getQuantity() + 1);
            orderDetailDAO.save(orderDetail);
        }

        return "redirect:/cart/viewCart";
    }

    @GetMapping("/cart/viewCart")
    public ModelAndView viewCart() {
        ModelAndView response = new ModelAndView("cart/viewCart");

        User user = authenticatedUserService.loadCurrentUser();

        Order order = orderDAO.findByUser(user.getId());

        if(order == null) {
            log.debug("No order found for user " + user.getEmail());
            response.setViewName("redirect:/");
            return response;
        }

        List<OrderDetail> orderDetails = orderDetailDAO.findByOrderId(order.getId());

        log.debug("In view cart controller method with email = " + user.getEmail());

        int totalPrice = 0;

        for(OrderDetail orderDetail : orderDetails) {
            log.debug("Product: " + orderDetail.getProduct().getProductName() + " Quantity: " + orderDetail.getQuantity());
            totalPrice += orderDetail.getProduct().getProductMSRP().intValue() * orderDetail.getQuantity();
        }

        response.addObject("orderDetails", orderDetails);
        response.addObject("totalPrice", totalPrice);

        return response;
    }

    @GetMapping("/cart/checkout")
    public ModelAndView checkout() {
        ModelAndView response = new ModelAndView("cart/checkout");

        User user = authenticatedUserService.loadCurrentUser();

        Order order = orderDAO.findByUser(user.getId());


        return response;
    }

    @GetMapping("/cart/checkoutSubmit")
    public ModelAndView checkoutSubmit() {
        ModelAndView response = new ModelAndView("cart/orderPlaced");

        User user = authenticatedUserService.loadCurrentUser();

        Order order = orderDAO.findByUser(user.getId());

        order.setStatus("ORDERED");
        orderDAO.save(order);

        return response;
    }

    @GetMapping("/cart/orderPlaced")
    public ModelAndView orderPlaced() {
        ModelAndView response = new ModelAndView("cart/orderPlaced");

        return response;
    }

    @GetMapping("/cart/removeItem/{id}")
    public String removeItem(@PathVariable Integer id) {
        User user = authenticatedUserService.loadCurrentUser();

        Product product = productDAO.findById(id);
        log.debug("In remove from cart controller method with productId = " + product.getId() + " and email = " + user.getEmail());

        Order order = orderDAO.findByUser(user.getId());

        if(order == null) {
            log.debug("No order found for user " + user.getEmail());
            return "redirect:/";
        } else {
            log.debug("Found existing order for user " + user.getEmail());
        }

        OrderDetail orderDetail = orderDetailDAO.findByOrderIdAndProductId(order.getId(), id);

        if(orderDetail == null) {
            log.debug("No order detail found for order " + order.getId() + " and product " + product.getId());
            return "redirect:/";
        } else {
            log.debug("Found existing order detail for order " + order.getId() + " and product " + product.getId());
            orderDetailDAO.delete(orderDetail);
        }

        return "redirect:/cart/viewCart";
    }


}
