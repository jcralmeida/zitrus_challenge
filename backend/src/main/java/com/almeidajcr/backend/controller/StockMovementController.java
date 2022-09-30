package com.almeidajcr.backend.controller;

import com.almeidajcr.backend.converter.StockMovementMapper;
import com.almeidajcr.backend.dto.StockMovementDto;
import com.almeidajcr.backend.dto.StockMovementInputDto;
import com.almeidajcr.backend.entity.StockMovement;
import com.almeidajcr.backend.exception.InsufficientAmountException;
import com.almeidajcr.backend.service.StockMovementService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

/**
 * Define the REST endpoint that handle the {@link StockMovement} entity.
 */
@RestController
@RequestMapping("/api")
public class StockMovementController {

  @Autowired
  private StockMovementService stockMovementService;

  @Autowired
  private StockMovementMapper stockMovementMapper;

  /**
   * Define the POST endpoint for the {@link StockMovement} entity.
   *
   * @param inputDto The stock movement request.
   *
   * @return A {@link StockMovementDto} object as response body.
   */
  @PostMapping("/stock_movements")
  public ResponseEntity<StockMovementDto> save(
      @RequestBody StockMovementInputDto inputDto) {
    try {
      StockMovement stock = stockMovementService.save(inputDto);

      return new ResponseEntity<>(stockMovementMapper.toStockMovementDto(stock),
          HttpStatus.CREATED);
    } catch (InsufficientAmountException exception) {
      throw new ResponseStatusException(HttpStatus.NOT_FOUND, exception.getMessage());
    }
  }

  /**
   * Define the GET endpoint for the {@link StockMovement} entity.
   *
   *
   * @return A list of {@link StockMovementDto} object as response body.
   */
  @GetMapping("/stock_movements")
  public ResponseEntity<List<StockMovementDto>> readAll() {
    List<StockMovement> stockMovements = stockMovementService.readAll();

    return new ResponseEntity<>(stockMovementMapper.toListStockMovementDto(stockMovements),
    HttpStatus.OK);
  }
}
