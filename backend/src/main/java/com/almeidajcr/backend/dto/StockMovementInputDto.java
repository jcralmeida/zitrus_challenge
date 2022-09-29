package com.almeidajcr.backend.dto;

import java.math.BigDecimal;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import com.almeidajcr.backend.enums.ActionEnum;


/**
 * A Data transfer object used in the response for the POST and PATCH endpoint.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StockMovementInputDto {
  private BigDecimal saleValue;
  private ActionEnum movement;
  private Long amount;
  private Date salesDate;
  private int productId;
}
