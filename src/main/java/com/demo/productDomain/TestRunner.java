package com.demo.productDomain;

import com.demo.productDomain.Product;
import com.demo.productDomain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class TestRunner implements CommandLineRunner {

    @Autowired
    private ProductRepository productRepository;

    @Override
    public void run(String... args) {
        Product p = new Product();
        p.setName("Notebook");
        p.setPrice(45.99);
        p.setQuantity(30);

        productRepository.save(p); // ✅ Test .save()

        System.out.println("Products in DB:");
        productRepository.findAll().forEach(prod ->
                System.out.println(prod.getId() + ": " + prod.getName() + " - ₹" + prod.getPrice())
        );
    }
}
