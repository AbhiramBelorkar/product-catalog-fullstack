package com.ecom.product.catalog.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "category",
                cascade = CascadeType.ALL,
                fetch = FetchType.LAZY)
    private Set<Product> products;

    // @OneToMany: This annotation tells JPA:
    // "One Category can be associated with many Products."

    // mappedBy = "category"
    //This tells JPA:
    //"The category field inside the Product entity owns the relationship."
    // So, JPA will not create a join table. It uses the category_id foreign
    // key in the product table.

    // cascade = CascadeType.ALL
    //Any operation performed on the Category (like save, delete) will cascade to its products.

    // fetch = FetchType.LAZY
    //Products won't be loaded from the database until you explicitly access the products set.
    //This improves performance by not loading everything unless needed.


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
