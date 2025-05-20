package com.learn.controller;


import com.learn.dao.SaleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/sales")
public class SaleController {
    @Autowired
    private SaleDao saleDao;
}
