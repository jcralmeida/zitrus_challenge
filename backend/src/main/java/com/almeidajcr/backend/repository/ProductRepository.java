package com.almeidajcr.backend.repository;

import com.almeidajcr.backend.dto.FilteringByTypeDto;
import com.almeidajcr.backend.dto.ProfitDto;
import com.almeidajcr.backend.entity.Product;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The repository for the {@link Product} entity.
 */
public interface ProductRepository extends JpaRepository<Product, Integer> {
  @Query(value =
      "SELECT sm.product_id as productId, p.description, p.type, sum(sm.amount) "
          + "as outAmount, p.amount from stock_movements sm "
          + "join products p on p.id = sm.product_id WHERE\n"
          + "sm.movement = 'SAIDA' and p.type = :type "
          + "group by sm.product_id, p.description, p.type, p.amount",
      nativeQuery = true)
  List<FilteringByTypeDto> findAllByTypeNative(@Param("type") String typeEnum);

  @Query(value = "SELECT sum(sm.amount) as outAmount,"
      + "(sum(sm.sale_value) - (p.value * sum(sm.amount))) as profit\n"
      + "from stock_movements sm\n"
      + "join products p on p.id = sm.product_id\n"
      + "WHERE sm.movement = 'SAIDA'\n"
      + "and sm.product_id = :productId\n"
      + "group by p.value",
      nativeQuery = true)
  ProfitDto findProfitByProductNative(@Param("productId") Long productId);
}
