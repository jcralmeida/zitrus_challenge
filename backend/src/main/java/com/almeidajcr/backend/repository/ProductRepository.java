package com.almeidajcr.backend.repository;

import com.almeidajcr.backend.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The repository for the {@link Product} entity.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
}
