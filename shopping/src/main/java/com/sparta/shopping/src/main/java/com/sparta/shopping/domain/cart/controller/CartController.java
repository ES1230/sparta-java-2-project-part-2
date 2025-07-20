package com.sparta.shopping.domain.cart.controller;

import com.sparta.shopping.common.exception.ServiceException;
import com.sparta.shopping.common.exception.ServiceExceptionCode;
import com.sparta.shopping.common.response.ApiResponse;
import com.sparta.shopping.domain.cart.dto.CartRequest;
import com.sparta.shopping.domain.cart.dto.CartResponse;
import com.sparta.shopping.domain.cart.entity.Cart;
import com.sparta.shopping.domain.cart.repository.CartRepository;
import com.sparta.shopping.domain.cart.service.CartService;
import com.sparta.shopping.domain.user.entity.User;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/carts")
public class CartController {

  private final CartService cartService;
  private final CartRepository cartRepository;

  @PostMapping("/items")
  public ApiResponse<?> addItem(@RequestBody @Valid CartRequest request,User user){
    cartService.addCartItem(user,request.getProductId(), request.getQuantity());
    return  ApiResponse.success("장바구니에 상품이 추가되었습니다");
  }

  @GetMapping
  public ApiResponse<List<CartResponse>> getCartItem(User user){
    List<CartResponse> cartItems = cartService.getCartItems(user);
    return ApiResponse.success(cartItems);
  }

  @DeleteMapping("/items/{cartItemId}")
  public ApiResponse<?> deleteCartItem(@PathVariable Long cartItemId, User user){
    cartService.deleteCartItem(user, cartItemId);
    return ApiResponse.success();
  }



}
