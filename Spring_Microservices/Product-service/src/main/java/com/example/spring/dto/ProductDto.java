package com.example.spring.dto;

public class ProductDto {

	private String productName;
	private String productType;
	private int cost;
	private int quantity;

	
	public ProductDto(String product_name, String product_type, int cost, int quantity) {
		super();
		this.productName = product_name;
		this.productType = product_type;
		this.cost = cost;
		this.quantity = quantity;
	}
	public ProductDto() {
		super();
	}
	

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductType() {
		return productType;
	}
	public void setProductType(String productType) {
		this.productType = productType;
	}
	public int getCost() {
		return cost;
	}
	public void setCost(int cost) {
		this.cost = cost;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
   
}
