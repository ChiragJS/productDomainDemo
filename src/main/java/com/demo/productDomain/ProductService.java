package com.demo.productDomain;

import com.demo.productDomain.Product;
import com.demo.productDomain.ProductDTO;
import com.demo.productDomain.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
    public Optional<Product> updateProduct(Long id, ProductDTO dto) {
        return productRepository.findById(id).map(product -> {
            product.setName(dto.name);
            product.setPrice(dto.price);
            product.setQuantity(dto.quantity);
            return productRepository.save(product);
        });
    }

    public boolean deleteProduct(Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return true;
        }
        return false;
    }


    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
