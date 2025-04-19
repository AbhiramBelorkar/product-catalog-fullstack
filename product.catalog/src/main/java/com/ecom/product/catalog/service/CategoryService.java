package com.ecom.product.catalog.service;

import com.ecom.product.catalog.domain.Category;
import com.ecom.product.catalog.repo.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo repo;

    public CategoryService(CategoryRepo repo){
        this.repo = repo;
    }

    public List<Category> getAllCategories(){
        return repo.findAll();
    }
}
