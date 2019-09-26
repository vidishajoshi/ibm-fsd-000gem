package com.example.spring.controller;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.spring.dto.ProductDto;
import com.example.spring.model.ProductRequestModel;
import com.example.spring.model.ProductResponseModel;
import com.example.spring.service.ProductService;

@RestController
@RequestMapping("/product")
public class HomeController {

	@Autowired ProductService productService;
	
	@RequestMapping("/")
     public void goHome() {
    	 
     }
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody ProductRequestModel model) {
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductDto dto=mapper.map(model,ProductDto.class);
		productService.addProduct(dto);
	}
	
	@GetMapping("/display")
	public List<ResponseEntity<ProductResponseModel>> displayProduct(){
		List<ProductDto> plist=productService.getAllProduct();
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		List<ResponseEntity<ProductResponseModel>> list=new ArrayList<ResponseEntity<ProductResponseModel>>();
		for(ProductDto j:plist) {
			ProductResponseModel m = mapper.map(j,ProductResponseModel.class);
			list.add(ResponseEntity.status(HttpStatus.CREATED).body(m));
		}
		return list;
	}
	
	@GetMapping("/delete/{id}")
	public void deleteProduct(@PathVariable("id") Integer id) {
		productService.deleteProduct(id);
	}
	
	
	@GetMapping("/searchId/{id}")
	public ResponseEntity<ProductResponseModel> displayById(@PathVariable("id") Integer id){
		ProductDto dto=productService.getProductById(id);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductResponseModel pr=mapper.map(dto,ProductResponseModel.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pr);
	}
	
	@GetMapping("/searchName/{pname}")
	public ResponseEntity<ProductResponseModel> displayByName(@PathVariable("pname") String pname){
		ProductDto dto=productService.getProductByName(pname);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductResponseModel pr=mapper.map(dto,ProductResponseModel.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pr);
	}
	 
	@GetMapping("/search/{ptype}")
	public ResponseEntity<ProductResponseModel> displayByType(@PathVariable("ptype") String ptype){
		ProductDto dto=productService.getProdcutByType(ptype);
		ModelMapper mapper = new ModelMapper();
		mapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		ProductResponseModel pr=mapper.map(dto,ProductResponseModel.class);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(pr);
	}
}
