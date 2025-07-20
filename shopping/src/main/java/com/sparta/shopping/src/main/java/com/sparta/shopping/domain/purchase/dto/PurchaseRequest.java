package com.sparta.shopping.domain.purchase.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class PurchaseRequest {

    Long productId;

    @NotNull
    @Positive //값을 양수로 제한
    Integer quantity;

    String shippingAddress;


}
