package com.almeidajcr.backend.entity;

import com.almeidajcr.backend.enums.ProductTypeEnum;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Set;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * Represent the Product Entity in the rest application.
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "products")
public class Product implements Serializable {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column(unique = true)
  private UUID code;

  private String description;

  @OneToMany(mappedBy = "product", fetch = FetchType.LAZY)
  private Set<StockMovement> stockMovements;

  @Enumerated(EnumType.STRING)
  private ProductTypeEnum type;
  private BigDecimal value;
  private long amount;
}
