package com.sparta.shopping.domain.purchase.controller;

import com.sparta.shopping.common.response.ApiResponse;
import com.sparta.shopping.domain.purchase.dto.PurchaseRequest;
import com.sparta.shopping.domain.purchase.dto.PurchaseResponse;
import com.sparta.shopping.domain.purchase.service.PurchaseService;
import com.sparta.shopping.domain.user.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
@RequiredArgsConstructor
public class PurchaseController {

  private final PurchaseService purchaseService;

  @PostMapping("/from-cart")
  public ApiResponse<?> purchaseFromCart(User user, @RequestBody PurchaseRequest request) {
    PurchaseResponse response = purchaseService.purchaseFromCart(user, request);
    return ApiResponse.success(response);
  }


}
