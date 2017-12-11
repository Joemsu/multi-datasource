package io.github.joemsu.config;

import io.github.joemsu.customer.dao.CustomerRepository;
import io.github.joemsu.customer.dao.pojo.CustomerDO;
import io.github.joemsu.order.dao.OrderRepository;
import io.github.joemsu.order.dao.pojo.OrderDO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * @author joemsu 2017-12-11 下午4:02
 */
@Component
public class DataInitConfig {

    private final CustomerRepository customerRepository;

    private final OrderRepository orderRepository;

    @Autowired
    public DataInitConfig(CustomerRepository customerRepository, OrderRepository orderRepository) {
        this.customerRepository = customerRepository;
        this.orderRepository = orderRepository;
    }

    /**
     * 初始化数据
     */
    @PostConstruct
    public void init() {
        if (!customerRepository.exists(1L)) {
            CustomerDO customerDO = new CustomerDO();
            customerDO.setFirstName("Hello");
            customerDO.setLastName("World");
            customerRepository.save(customerDO);
        }

        if (!orderRepository.exists(1L)) {
            OrderDO orderDO = new OrderDO();
            orderDO.setCustomerId(1L);
            orderDO.setOrderDate(new Date());
            orderRepository.save(orderDO);
        }
    }

}
