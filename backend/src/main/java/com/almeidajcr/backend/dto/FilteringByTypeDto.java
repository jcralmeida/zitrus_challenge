package com.almeidajcr.backend.dto;

import com.almeidajcr.backend.enums.ProductTypeEnum;

/**
 * A Data transfer object used in the request body for the GET endpoint when
 * filtering by type.
 */
public interface FilteringByTypeDto {
  Integer getProductId();

  String getDescription();

  ProductTypeEnum getType();

  Long getOutAmount();

  Long getAmount();
}
