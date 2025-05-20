package com.learn.controller;

import com.learn.dao.ProductDao;
import com.learn.entity.ProductEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/products")
public class ProductController {
    @Autowired
    private ProductDao productDao;

    @PostMapping(path = "/add-new-product")
    public ProductEntity addNewProduct(@RequestBody ProductEntity productEntity) {
        return this.productDao.addNewProduct(productEntity);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Integer id) {
        return this.productDao.deleteProduct(id);
    }
}
