package com.demo.productDomain;

import com.demo.productDomain.Product;
import com.demo.productDomain.ProductDTO;
import com.demo.productDomain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(ProductDTO dto) {
        Product product = new Product();
        product.setName(dto.name);
        product.setPrice(dto.price);
        product.setQuantity(dto.quantity);
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
