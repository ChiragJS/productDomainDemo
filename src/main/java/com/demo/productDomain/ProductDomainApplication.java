package com.demo.productDomain;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class ProductDomainApplication {
	@GetMapping("/")
	public String hello(){
		return "Hello from Spring Boot ";
	}
	public static void main(String[] args) {
		SpringApplication.run(ProductDomainApplication.class, args);
	}
}
