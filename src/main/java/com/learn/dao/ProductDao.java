package com.learn.dao;

import com.learn.entity.ProductEntity;
import com.learn.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class ProductDao {
    @Autowired
    private ProductRepository productRepository;

    public ResponseEntity<?> findById(Integer id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isPresent()) {
            return ResponseEntity.ok(product.get());
        } else {
            Map<String, String> message = new HashMap<>();
            message.put("message", "Product not found!");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
        }
    }


    public ProductEntity addNewProduct(ProductEntity productEntity) {
        return this.productRepository.save(productEntity);
    }

    public ResponseEntity<?> deleteProduct(Integer id) {
        ResponseEntity<?> response = this.findById(id);
        if (response.getStatusCode() == HttpStatus.OK) {
            ProductEntity product = (ProductEntity) response.getBody();
            assert product != null;
            productRepository.delete(product);
            return ResponseEntity.ok(Map.of("message", "Product deleted successfully."));
        } else {
            return response;
        }
    }

}
