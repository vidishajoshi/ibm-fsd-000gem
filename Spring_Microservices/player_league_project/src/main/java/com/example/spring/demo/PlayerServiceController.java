package com.example.spring.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PlayerServiceController {

	
	@Autowired
	 PlayerServiceClient playerServiceClient;

	 @GetMapping("/fetchPlayers")
	 public ResponseEntity <? > fetchProducts() {

	  return ResponseEntity.ok(playerServiceClient.findPlayer());
	 }

	 @GetMapping("/addPlay")
	 public ResponseEntity < ? > AddProduct(@RequestBody()) {

	  return ResponseEntity.ok(productServiceClient.getProduct(id));
	 }

}
