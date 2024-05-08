package org.perscholas.casestudy.controller;

import lombok.extern.slf4j.Slf4j;
import org.perscholas.casestudy.database.dao.OrderDetailDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Slf4j
@Controller
public class OrderDetailController {
    @Autowired
    private OrderDetailDAO orderDetailDao;

    @GetMapping("/orderDetail/create")
    public ModelAndView createOrderDetail() {
        ModelAndView response = new ModelAndView("orderDetail/create");



        log.debug("In create orderDetail with no args");

        return response;
    }
}
