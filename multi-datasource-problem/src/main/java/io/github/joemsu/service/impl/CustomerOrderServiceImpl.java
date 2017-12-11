package io.github.joemsu.service.impl;

import io.github.joemsu.customer.dao.CustomerRepository;
import io.github.joemsu.customer.dao.pojo.CustomerDO;
import io.github.joemsu.order.dao.OrderRepository;
import io.github.joemsu.order.dao.pojo.OrderDO;
import io.github.joemsu.service.CustomerOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author joemsu 2017-12-07 下午4:25
 */
@Service
public class CustomerOrderServiceImpl implements CustomerOrderService {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public CustomerOrderServiceImpl(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create() {
        CustomerDO customer = new CustomerDO();
        customer.setFirstName("Joe");
        customer.setLastName("Zhou");
        this.customerRepository.save(customer);
        OrderDO order = new OrderDO();
        order.setCustomerId(123L);
        order.setOrderDate(new Date());
        this.orderRepository.save(order);
        throw new RuntimeException("This is a test for Transactional");
    }

}
