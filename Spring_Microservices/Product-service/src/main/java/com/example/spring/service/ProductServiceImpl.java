package com.example.spring.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.spring.ProductRepo;
import com.example.spring.dto.ProductDto;
import com.example.spring.entity.Product;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired ProductRepo productRepo;
	
	@Override
	public void addProduct(ProductDto dto) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		Product product = mapper.map(dto,Product.class);
		productRepo.save(product);
		
	}

	@Override
	public List<ProductDto> getAllProduct() {
		List<Product> plist=productRepo.findAll();
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ProductDto> pdto=new ArrayList<ProductDto>();
		for(Product p:plist) {
			pdto.add(mapper.map(p,ProductDto.class));
		}
		return pdto;
	}

	@Override
	public ProductDto getProductById(Integer id) {
		Optional<Product> product=productRepo.findById(id);
		Product p=new Product();
		if(product.isPresent()) {
			 p=product.get();
		}
		else {
			System.out.println("there is errro");
		}
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto pd=mapper.map(p,ProductDto.class);
		return pd;
	}

	@Override
	public ProductDto getProductByName(String pname) {
		Product p= productRepo.findByProductName(pname);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto pd=mapper.map(p,ProductDto.class);
		return pd;
	}

	@Override
	public ProductDto getProdcutByType(String ptype) {
		Product p= productRepo.findByProductType(ptype);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto pd=mapper.map(p,ProductDto.class);
		return pd;
	}

	@Override
	public void deleteProduct(Integer id) {
		productRepo.deleteById(id);
		
	}

}
