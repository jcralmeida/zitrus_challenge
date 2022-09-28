package com.almeidajcr.backend.converter;

import com.almeidajcr.backend.dto.ProductDto;
import com.almeidajcr.backend.dto.ProductInputDto;
import com.almeidajcr.backend.entity.Product;
import java.util.List;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

/**
 * The converter class between the entity {@link Product} and the DTOs,
 * {@link ProductDto} and {@link ProductInputDto}.
 */
@Mapper(componentModel = "spring")
public interface ProductMapper {
  @Mapping(source = "description", target = "description")
  @Mapping(source = "code", target = "code")
  ProductDto toProductDto(Product product);

  List<ProductDto> toListProductDto(List<Product> products);
}
