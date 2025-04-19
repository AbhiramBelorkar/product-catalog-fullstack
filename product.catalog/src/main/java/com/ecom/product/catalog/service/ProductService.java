package com.ecom.product.catalog.service;

import com.ecom.product.catalog.domain.Product;
import com.ecom.product.catalog.repo.ProductRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private final ProductRepo repo;

    public ProductService(ProductRepo repo) {
        this.repo = repo;
    }

    public List<Product> getAllProducts(){
        return repo.findAll();
    }

    public List<Product> getProductByCategory(Long categoryId){
        return repo.findByCategoryId(categoryId);
    }


}
