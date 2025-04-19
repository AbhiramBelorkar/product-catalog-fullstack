package com.ecom.product.catalog.repo;

import com.ecom.product.catalog.domain.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepo extends JpaRepository<Product, Long> {

    List<Product> findByCategoryId(Long categoryId);
    // This is known as spring data jpa naming convention
    // find: select, By: where clause, Id: is key, List<Product>: Product table
}
