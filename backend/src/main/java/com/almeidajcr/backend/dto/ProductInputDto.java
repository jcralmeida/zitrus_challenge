package com.almeidajcr.backend.dto;

import com.almeidajcr.backend.enums.ProductTypeEnum;
import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * A Data transfer object used in the request body for the POST endpoint.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductInputDto {
  private String description;
  private ProductTypeEnum type;
  private BigDecimal value;
  private Long amount;
}
