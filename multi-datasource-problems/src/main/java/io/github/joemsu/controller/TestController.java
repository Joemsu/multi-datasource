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

    @RequestMapping("/session")
    public String session() {
        customerOrderService.getCustomerOne(1L);
        return "success";
    }

    @RequestMapping("/nosession1")
    public String nosession1() {
        new Thread(() -> customerOrderService.getCustomerOne(1L)).start();
        return "could not initialize proxy - no Session";
    }

    @RequestMapping("/nosession2")
    public String nosession2() {
        customerOrderService.getOrderOne(1L);
        return "could not initialize proxy - no Session";
    }

    @RequestMapping("/create")
    public String code() {
        customerOrderService.create();
        return "Transaction rollback only one database";
    }
}
