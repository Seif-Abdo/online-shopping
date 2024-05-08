package org.perscholas.casestudy.database.dao;

import org.junit.jupiter.api.*;
import org.perscholas.casestudy.database.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserDAOTest {
    @Autowired
    private UserDAO userDAO;

    @Test
    @Order(1)
    public void createUserTest() {
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

        //When
        user = userDAO.save(user);

        //Then
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("Test Email", user.getEmail());
        Assertions.assertEquals("Test Password", user.getPassword());
        Assertions.assertEquals("Test First Name", user.getFirstName());
        Assertions.assertEquals("Test Last Name", user.getLastName());
        Assertions.assertEquals("Test City", user.getCity());
        Assertions.assertEquals("Test Address", user.getAddress());
        Assertions.assertEquals("Test State", user.getState());
        Assertions.assertEquals("Test Zip Code", user.getZipCode());
    }

    @Test
    @Order(2)
    public void findByEmailIgnoreCaseTest() {
        //Given
        String email = "Test Email";

        //When
        User user = userDAO.findByEmailIgnoreCase(email);

        //Then
        Assertions.assertNotNull(user.getId());
        Assertions.assertEquals("Test Email", user.getEmail());
        Assertions.assertEquals("Test Password", user.getPassword());
        Assertions.assertEquals("Test First Name", user.getFirstName());
        Assertions.assertEquals("Test Last Name", user.getLastName());
        Assertions.assertEquals("Test City", user.getCity());
        Assertions.assertEquals("Test Address", user.getAddress());
        Assertions.assertEquals("Test State", user.getState());
        Assertions.assertEquals("Test Zip Code", user.getZipCode());
    }

    @Test
    @Order(3)
    public void deleteByEmailIgnoreCaseTest() {
        //Given
        String email = "Test Email";

        //When
        int deleted = userDAO.deleteByEmail(email);

        //Then
        Assertions.assertEquals(1,deleted);
    }
}
