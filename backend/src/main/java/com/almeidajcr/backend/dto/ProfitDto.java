package com.almeidajcr.backend.dto;

import java.math.BigDecimal;

/**
 * A Data transfer object used in the request body for the GET endpoint when
 * looking for profit information.
 */
public interface ProfitDto {
  Long getOutAmount();

  BigDecimal getProfit();
}
