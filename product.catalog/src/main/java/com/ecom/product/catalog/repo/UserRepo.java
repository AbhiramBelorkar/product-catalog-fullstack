package com.ecom.product.catalog.repo;

import com.ecom.product.catalog.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepo extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);

    Optional<User> findByEmail(String email);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);

    //Optional<T> is a container object introduced in Java 8 that may or may not contain a non-null value.
    //It's used to avoid null pointer exceptions and write cleaner code.
}
