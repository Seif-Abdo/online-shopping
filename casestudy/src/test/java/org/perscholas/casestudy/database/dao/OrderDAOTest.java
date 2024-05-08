package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.casestudy.database.entity.Order;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderDAOTest {
    @Autowired
    private OrderDAO orderDAO;

    @Autowired
    private UserDAO userDAO;

    @Test
    @org.junit.jupiter.api.Order(1)
    public void createOrderTest() {
        //Given
        User user = new User();
        user.setEmail("Test Email");
        user.setPassword("Test Password");
        user.setFirstName("Test First Name");
        user.setLastName("Test Last Name");
        user.setCity("Test City");
        user.setAddress("Test Address");
        user.setState("Test State");
        user.setZipCode("Test Zip Code");

        user = userDAO.save(user);

        Order order = new Order();
        order.setUser(user);
        order.setStatus("CART");
        order.setCreditCard("Test Credit Card");
        order.setShippingAddress("Test Shipping Address");

        //When
        order = orderDAO.save(order);

        //Then
        Assertions.assertNotNull(order.getId());
        Assertions.assertEquals(user, order.getUser());
        Assertions.assertEquals("CART", order.getStatus());
        Assertions.assertEquals("Test Credit Card", order.getCreditCard());
        Assertions.assertEquals("Test Shipping Address", order.getShippingAddress());
    }

    @Test
    @org.junit.jupiter.api.Order(2)
    public void findByUserId() {
        //Given
        User user = userDAO.findByEmailIgnoreCase("Test Email");

        //When
        Order order = orderDAO.findByUser(user.getId());

        //Then
        Assertions.assertNotNull(order.getId());
        Assertions.assertEquals(user.getId(), order.getUser().getId());
        Assertions.assertEquals("CART", order.getStatus());
        Assertions.assertEquals("Test Credit Card", order.getCreditCard());
        Assertions.assertEquals("Test Shipping Address", order.getShippingAddress());
    }

    @Test
    @org.junit.jupiter.api.Order(3)
    public void deleteById() {
        //Given
        User user = userDAO.findByEmailIgnoreCase("Test Email");
        Order order = orderDAO.findByUser(user.getId());

        //When
        int deleted = orderDAO.deleteById(order.getId());
        userDAO.deleteByEmail("Test Email");
        //Then
        Assertions.assertEquals(1, deleted);
    }
}
