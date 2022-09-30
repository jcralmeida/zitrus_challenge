package com.almeidajcr.backend.dto;

import com.almeidajcr.backend.enums.ActionEnum;
import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * A Data transfer object used in the response for the GET and Post endpoint.
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockMovementDto {
  private int id;
  private BigDecimal saleValue;
  private ActionEnum movement;
  private Long amount;
  private Date salesDate;
  private int productId;
}
