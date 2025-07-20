package com.sparta.shopping.domain.purchase.dto;

import com.sparta.shopping.domain.product.entity.Product;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseResponse {

  Long id;
  BigDecimal totalPrice;
  Product product;

}
