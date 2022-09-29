package com.almeidajcr.backend.repository;

import com.almeidajcr.backend.entity.StockMovement;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The repository for the {@link StockMovement} entity.
 */
public interface StockMovementRepository extends JpaRepository<StockMovement, Integer> {
}
