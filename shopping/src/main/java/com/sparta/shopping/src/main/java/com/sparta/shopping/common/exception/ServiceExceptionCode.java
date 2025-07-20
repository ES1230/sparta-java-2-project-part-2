package com.sparta.shopping.common.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public enum ServiceExceptionCode {

  NOT_FOUND_USER("유저를 찾을 수 없습니다."),
  NOT_FOUND_PRODUCT("상품을 찾을 수 없습니다."),
  NOT_FOUND_CART_ITEM("장바구니에 해당 상품이 없습니다."),
  EMPTY_CART("장바구니가 비어있습니다."),
  INSUFFICIENT_STOCK("상품의 재고가 부족합니다."),
  OUT_OF_STOCK_PRODUCT("재고 수량이 없습니다."),
  UNAUTHORIZED("권한이 없습니다."),
  ;

  final String message;
}
