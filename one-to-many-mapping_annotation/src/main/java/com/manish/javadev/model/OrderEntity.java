package com.manish.javadev.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_ORDER")
public class OrderEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "ORDER_ID")
	private long id;

	@Column(name = "ORDER_ITEM_NAME")
	private String itemName;

	@Column(name = "ORDER_DATE")
	private Date orderDate;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CUSTOMER_ID_FK", referencedColumnName = "CUSTOMER_ID")
	private CustomerEntity customerEntity;

	public OrderEntity() {
	}

	public OrderEntity(String itemName, Date orderDate) {
		super();
		this.itemName = itemName;
		this.orderDate = orderDate;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public CustomerEntity getCustomerEntity() {
		return customerEntity;
	}

	public void setCustomerEntity(CustomerEntity customerEntity) {
		this.customerEntity = customerEntity;
	}

	@Override
	public String toString() {
		return "OrderEntity [id=" + id + ", itemName=" + itemName
				+ ", orderDate=" + orderDate + "]";
	}

}
