package com.example.spring.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopping")
public class Shopping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private int total;
	private String day;
	private Date date;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="product_id")
	private Product p;
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id")
	private Customer c;
	public Shopping() {
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Product getP() {
		return p;
	}
	public void setP(Product p) {
		this.p = p;
	}
	public Customer getC() {
		return c;
	}
	public void setC(Customer c) {
		this.c = c;
	}
	
	
}
