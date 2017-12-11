package io.github.joemsu.customer.dao;

import io.github.joemsu.customer.dao.pojo.CustomerDO;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author joemsu 2017-12-11 下午3:26
 */
public interface CustomerRepository extends JpaRepository<CustomerDO, Long> {
}
