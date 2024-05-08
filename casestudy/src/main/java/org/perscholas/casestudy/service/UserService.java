package org.perscholas.casestudy.service;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.UserDAO;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.formbean.RegisterUserFormBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UserService {
    @Autowired
    private UserDAO userDao;

    @Lazy
    @Autowired
    private PasswordEncoder passwordEncoder;

    public User createUser(RegisterUserFormBean form) {
        User user = new User();

        user.setEmail(form.getEmail().toLowerCase());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        user.setCity(form.getCity());
        user.setAddress(form.getAddress());
        user.setState(form.getState());
        user.setZipCode(form.getZipCode());

        String encoded = passwordEncoder.encode(form.getPassword());
        log.debug("Encoded password: " + encoded);
        user.setPassword(encoded);

        return userDao.save(user);
    }
}
