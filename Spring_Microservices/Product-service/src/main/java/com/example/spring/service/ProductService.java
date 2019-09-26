package com.example.spring.service;

import java.util.List;

import com.example.spring.dto.ProductDto;


public interface ProductService {

	public void addProduct(ProductDto dto);
	public List<ProductDto> getAllProduct();
	public ProductDto getProductById(Integer id);
	public ProductDto getProductByName(String pname);
	public ProductDto getProdcutByType(String ptype);
	public void deleteProduct(Integer id);
}
