package com.almeidajcr.backend.controller;

import com.almeidajcr.backend.converter.ProductMapper;
import com.almeidajcr.backend.dto.FilteringByTypeDto;
import com.almeidajcr.backend.dto.ProductDto;
import com.almeidajcr.backend.dto.ProductInputDto;
import com.almeidajcr.backend.dto.ProfitDto;
import com.almeidajcr.backend.entity.Product;
import com.almeidajcr.backend.enums.ProductTypeEnum;
import com.almeidajcr.backend.service.ProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Define the REST endpoint that handle the {@link Product} entity.
 */
@RestController
@RequestMapping("/api")
public class ProductController {
  @Autowired
  private ProductService productService;

  @Autowired
  private ProductMapper productMapper;

  /**
   * Define the GET all endpoint for the {@link Product}.
   *
   * @return A list with all the registered {@link Product}.
   */
  @GetMapping("/products")
  public ResponseEntity<List<ProductDto>> getAll() {
    List<Product> products = productService.readAll();

    List<ProductDto> productDtos = productMapper.toListProductDto(products);
    return new ResponseEntity<>(productDtos, HttpStatus.OK);
  }

  /**
   * Define the GET endpoint to retrieve the necessary information
   * about product stocks and sales.
   *
   * @param typeEnum the type of the Product used in the filtering.
   *
   * @return A list of {@link FilteringByTypeDto}.
   */
  @GetMapping("/products/filtering")
  public ResponseEntity<List<FilteringByTypeDto>> getAll(
      @RequestParam(name = "type") ProductTypeEnum typeEnum) {
    List<FilteringByTypeDto> products = productService.getAllByTypeFiltering(typeEnum);

    return new ResponseEntity<>(products, HttpStatus.OK);
  }

  /**
   * Define the GET endpoint to retrieve information about profit and
   * the amount of product that was sold. It is necessary to pass the id
   * of the product in the path.
   *
   * @param id  the product id.
   *
   * @return a {@link ProfitDto} response.
   */
  @GetMapping("/products/{id}/profit")
  public ResponseEntity<ProfitDto> getProfitFromProduct(@PathVariable Long id) {
    ProfitDto profitByProduct = productService.getProfitByProduct(id);

    return ResponseEntity.ok().body(profitByProduct);
  }

  /**
   * Define the POST endpoint for the {@link Product}.
   *
   * @param productInputDto The income request.
   *
   * @return The registered {@link Product} object.
   */
  @PostMapping("/products")
  public ResponseEntity<ProductDto> save(@RequestBody ProductInputDto productInputDto) {
    Product product = productService.save(productInputDto);

    return new ResponseEntity<>(productMapper.toProductDto(product), HttpStatus.CREATED);
  }

  /**
   * Define the DELETE endpoint for the {@link Product}.
   *
   * @param productId the {@link Product}.
   *
   * @return The response object with its actual {@link HttpStatus}.
   */
  @DeleteMapping("products/{id}")
  public ResponseEntity<?> delete(@PathVariable("id") Integer productId) {
    productService.delete(productId);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }

  /**
   * Define the PATCH endpoint for the {@link Product}.
   *
   * @param productId the {@link Product}.
   *
   * @return The response object with its actual {@link HttpStatus}.
   */
  @PatchMapping("products/{id}")
  public ResponseEntity updateProduct(@PathVariable("id") int productId,
                                      @RequestBody ProductInputDto productInputDto) {
    productService.update(productId, productInputDto);

    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
  }
}
