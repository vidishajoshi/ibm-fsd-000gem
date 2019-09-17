package com.example.demo.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.data.Images;

@RestController
public class ImageController {

	@Autowired
	private Environment env;
	
	@RequestMapping("/images")
	public List<Images> getAllImages(){
		List<Images> list=Arrays.asList(new Images(1l,"java-image_1","https://www.google.com/url?sa"),
				new Images(2l,"java image-2","=i&rct=j&q=&esrc=s&source=images&cd=&cad=rja&uact=8&ved=0ahUKEwiN-dSf0tTkAhVDdt8KHdp5Ca4QMwiDASgJMAk&url=https%3A%2F%2Fwww.theverge.com%2F2016%2F1%2F28%2F10858250%2Foracle-java-plugin-deprecation"),
				new Images(3l,"java-image-3","-jdk-9&psig=AOvVaw2DyaCFgPpYtDn2kFr3waSy&ust=1568699254498975&ictx=3&uact=3"));
		
		return list;
		
	}
}
