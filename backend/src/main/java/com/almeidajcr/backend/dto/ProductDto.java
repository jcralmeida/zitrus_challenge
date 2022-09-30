package com.almeidajcr.backend.dto;

import com.almeidajcr.backend.enums.ProductTypeEnum;
import java.math.BigDecimal;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Data transfer object used in the response for the GET endpoint.
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProductDto {
  private int id;
  private UUID code;
  private String description;
  private ProductTypeEnum type;
  private BigDecimal value;
  private long amount;
}
