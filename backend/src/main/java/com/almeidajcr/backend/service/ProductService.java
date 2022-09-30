package com.almeidajcr.backend.service;

import com.almeidajcr.backend.dto.ProductInputDto;
import com.almeidajcr.backend.entity.Product;
import com.almeidajcr.backend.exception.NotFoundException;
import com.almeidajcr.backend.repository.ProductRepository;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service responsible for the entity {@link Product}.
 */
@Service
public class ProductService {
  @Autowired
  private ProductRepository productRepository;

  public List<Product> readAll() {
    return productRepository.findAll();
  }

  /**
   * Create a new entity {@link Product} and persist it.
   *
   * @param productInputDto Product information to create the entity.
   *
   * @return The registered object.
   */
  public Product save(ProductInputDto productInputDto) {
    Product product = new Product().builder()
        .description(productInputDto.getDescription())
        .code(UUID.randomUUID())
        .type(productInputDto.getType())
        .value(productInputDto.getValue())
        .amount(productInputDto.getAmount()).build();

    return productRepository.save(product);
  }

  /**
   * Try to find a product based on its id. If it exists, we delete it.
   * Otherwise, we throw an exception to inform that the object doesn't exist.
   *
   * @param productId the product identifier.
   */
  public void delete(int productId) {
    Product product = getProductById(productId);

    productRepository.delete(product);
  }

  /**
   * Try to find a product based on its id. If it exists, we update it.
   * Otherwise, we throw an exception to inform that the object doesn't exist.
   *
   * @param productId         the product identifier.
   * @param productInputDto   {@link Product} information to create the entity.
   */
  public void update(int productId, ProductInputDto productInputDto) {
    Product product = getProductById(productId);

    updateFieldsForPatch(product::setDescription, productInputDto.getDescription());
    updateFieldsForPatch(product::setAmount, productInputDto.getAmount());
    updateFieldsForPatch(product::setValue, productInputDto.getValue());
    updateFieldsForPatch(product::setType, productInputDto.getType());

    productRepository.save(product);
  }

  private <T> void updateFieldsForPatch(Consumer<T> setter, T value) {
    if (value != null) {
      setter.accept(value);
    }
  }

  private Product getProductById(int productId) {
    return productRepository.findById(productId)
        .orElseThrow(() -> new NotFoundException("Produto não encontrado"));
  }
}
