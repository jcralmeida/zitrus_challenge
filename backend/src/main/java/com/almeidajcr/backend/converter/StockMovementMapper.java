package com.almeidajcr.backend.converter;

import com.almeidajcr.backend.dto.StockMovementDto;
import com.almeidajcr.backend.entity.StockMovement;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The converter class between the entity {@link StockMovement} and DTO
 * {@link StockMovementDto}.
 */
@Mapper(componentModel = "spring")
public interface StockMovementMapper {
  @Mapping(source = "date", target = "salesDate")
  @Mapping(source = "product.id", target = "productId")
  StockMovementDto toStockMovementDto(StockMovement stockMovement);

  List<StockMovementDto> toListStockMovementDto(List<StockMovement> stockMovementList);
}
