package io.github.joemsu.order.dao;

import io.github.joemsu.order.dao.pojo.OrderDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joemsu 2017-12-11 下午3:25
 */
public interface OrderRepository extends JpaRepository<OrderDO, Long> {
}
