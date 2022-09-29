package com.almeidajcr.backend.service;

import com.almeidajcr.backend.dto.StockMovementInputDto;
import com.almeidajcr.backend.entity.Product;
import com.almeidajcr.backend.entity.StockMovement;
import com.almeidajcr.backend.enums.ActionEnum;
import com.almeidajcr.backend.exception.InsufficientAmountException;
import com.almeidajcr.backend.exception.InvalidFieldCombinationException;
import com.almeidajcr.backend.exception.NotFoundException;
import com.almeidajcr.backend.repository.ProductRepository;
import com.almeidajcr.backend.repository.StockMovementRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * The service responsible for the entity {@link StockMovement}.
 */
@Service
public class StockMovementService {
  @Autowired
  private StockMovementRepository stockMovementRepository;

  @Autowired
  private ProductRepository productRepository;

  /**
   * Return all the StockMovemnt registered in the Db.
   *
   * @return A list of {@link StockMovement}.
   */
  public List<StockMovement> readAll() {
    return stockMovementRepository.findAll();
  }

  /**
   * Persist a new StockMovement event. First, we check if the movement type is
   * equal to {@link ActionEnum#ENTRADA} and if the SaleValue is not null. If so,
   * we thrown an exception since those value can't be used together. After that,
   * we tried to retrieved the {@link Product} using the informed ID. If we can't find
   * it, a {@link NotFoundException} is used. Then, we check if we have the amount to be movement
   * in stock and change the value from the {@link Product} entity. Finally, we persist
   * both objects {@link StockMovement} and {@link Product}.
   *
   * @param inputDto The values sent by the user.
   *
   * @return  The response after persist data in DB.
   */
  public StockMovement save(StockMovementInputDto inputDto) {
    if (inputDto.getMovement() == ActionEnum.ENTRADA && inputDto.getSaleValue() != null) {
      throw new InvalidFieldCombinationException(
          "Não é possivel informar Entrada e valor de venda ao mesmo tempo");
    }

    Product product = productRepository.findById(inputDto.getProductId())
        .orElseThrow(() -> new NotFoundException("object.not_found"));

    if (inputDto.getMovement() == ActionEnum.SAIDA && inputDto.getAmount() > product.getAmount()) {
      throw new InsufficientAmountException("Quantidade de Produto insuficiente");
    } else if (inputDto.getMovement() == ActionEnum.SAIDA) {
      product.setAmount(product.getAmount() - inputDto.getAmount());
    }

    if (inputDto.getMovement() == ActionEnum.ENTRADA) {
      product.setAmount(inputDto.getAmount() + product.getAmount());
    }

    StockMovement stockMovement = StockMovement.builder()
        .amount(inputDto.getAmount())
        .date(inputDto.getSalesDate())
        .movement(inputDto.getMovement())
        .saleValue(inputDto.getSaleValue())
        .product(product)
        .build();

    stockMovement = stockMovementRepository.save(stockMovement);
    productRepository.save(product);

    return stockMovement;
  }
}
