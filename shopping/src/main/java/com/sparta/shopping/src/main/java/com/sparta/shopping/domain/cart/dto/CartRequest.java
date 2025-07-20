package com.sparta.shopping.domain.cart.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import java.math.BigDecimal;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level= AccessLevel.PRIVATE)
public class CartRequest {

  Long productId;

  @NotNull
  @Positive //값을 양수로 제한
  Integer quantity;


}
