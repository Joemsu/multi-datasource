package io.github.joemsu.controller;

import io.github.joemsu.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author joemsu 2017-12-07 下午4:29
 */
@RestController
@RequestMapping("/")
public class TestController {

    private final CustomerOrderService customerOrderService;

    @Autowired
    public TestController(CustomerOrderService customerOrderService) {
        this.customerOrderService = customerOrderService;
    }

    @RequestMapping("/create")
    public String code() {
        customerOrderService.create();
        return "success";
    }
}
