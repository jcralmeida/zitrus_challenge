package com.almeidajcr.backend.dto;

import com.almeidajcr.backend.enums.ProductTypeEnum;
import java.math.BigDecimal;


/**
 * A Data transfer object used in the request body for the POST endpoint.
 */
public class ProductInputDto {
  private final String description;
  private final ProductTypeEnum type;
  private final BigDecimal value;
  private final long amount;

  /**
   * Constructor for the {@link ProductInputDto}.
   *
   * @param description    A brief description of the product.
   * @param type           The {@link ProductTypeEnum} which the product belongs.
   * @param value          The moneteray value of the product.
   * @param amount         The quantity in stock.
   */
  public ProductInputDto(String description, ProductTypeEnum type, BigDecimal value, long amount) {
    this.description = description;
    this.type = type;
    this.value = value;
    this.amount = amount;
  }

  public String getDescription() {
    return description;
  }

  public ProductTypeEnum getType() {
    return type;
  }

  public BigDecimal getValue() {
    return value;
  }

  public long getAmount() {
    return amount;
  }
}
