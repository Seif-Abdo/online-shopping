package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.UserDAO;
import org.perscholas.casestudy.database.entity.User;
import org.perscholas.casestudy.security.AuthenticatedUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class UserController {
    @Autowired
    private UserDAO userDao;

    @Autowired
    private AuthenticatedUserService authenticatedUserService;
    @GetMapping("/user/account")
    public ModelAndView viewAccount() {
        ModelAndView response = new ModelAndView("user/account");

        User user = authenticatedUserService.loadCurrentUser();

        log.debug("User: " + user.getEmail() + " in view account");

        response.addObject("user", user);

        return response;
    }
}
