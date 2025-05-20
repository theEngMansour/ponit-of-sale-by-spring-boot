package com.learn.dao;

import com.learn.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleDao {
    @Autowired
    private SaleRepository saleRepository;
}
