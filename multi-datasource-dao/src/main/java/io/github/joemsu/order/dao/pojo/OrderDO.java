package io.github.joemsu.order.dao.pojo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * @author joemsu 2017-12-11 下午3:23
 */
@Entity
@Table(name = "t_order")
public class OrderDO implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	@Column(nullable = false)
	private Long customerId;

	@Column(nullable = false)
	@Temporal(TemporalType.DATE)
	private Date orderDate;

	public Long getId() {
		return id;
	}

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	@Override
	public String toString() {
		return "OrderDO{" +
				"id=" + id +
				", customerId=" + customerId +
				", orderDate=" + orderDate +
				'}';
	}
}
