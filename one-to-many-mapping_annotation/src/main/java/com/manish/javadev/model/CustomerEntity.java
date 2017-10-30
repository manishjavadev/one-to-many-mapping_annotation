package com.manish.javadev.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "TBL_CUSTOMER")
public class CustomerEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CUSTOMER_ID")
	private long id;

	@Column(name = "FIRST_NAME")
	private String firstName;

	@Column(name = "LAST_NAME")
	private String lastName;

	@Column(name = "AGE")
	private int age;

	@OneToMany(mappedBy = "customerEntity", cascade = CascadeType.ALL)
	private Set<OrderEntity> orderEntiy;

	public CustomerEntity() {
	}

	public CustomerEntity(String firstName, String lastName, int age) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Set<OrderEntity> getOrderEntiy() {
		if (orderEntiy == null) {
			return orderEntiy = new HashSet<OrderEntity>();
		}
		return orderEntiy;
	}

	@Override
	public String toString() {
		return "CustomerEntity [id=" + id + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + "]";
	}

}
