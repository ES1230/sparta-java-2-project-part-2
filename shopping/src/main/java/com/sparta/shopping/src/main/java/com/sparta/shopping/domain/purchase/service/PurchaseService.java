package com.sparta.shopping.domain.purchase.service;

import com.sparta.shopping.common.exception.ServiceException;
import com.sparta.shopping.common.exception.ServiceExceptionCode;
import com.sparta.shopping.domain.cart.dto.CartResponse;
import com.sparta.shopping.domain.cart.repository.CartRepository;
import com.sparta.shopping.domain.cart.service.CartService;
import com.sparta.shopping.domain.purchase.dto.PurchaseRequest;
import com.sparta.shopping.domain.purchase.dto.PurchaseResponse;
import com.sparta.shopping.domain.purchase.entity.Purchase;
import com.sparta.shopping.domain.purchase.repository.PurchaseRepository;
import com.sparta.shopping.domain.user.entity.User;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PurchaseService {

  private final PurchaseRepository purchaseRepository;
  private final CartRepository cartRepository;
  private final CartService cartService;

  @Transactional
  public PurchaseResponse purchaseFromCart(User user, PurchaseRequest request) {

    //장바구니 상품 가져오기
    List<CartResponse> cartList = cartService.getCartItems(user);

    if (cartList.isEmpty()) {
      throw new ServiceException(ServiceExceptionCode.EMPTY_CART);
    }

    //재고 확인 및 감소
    for(CartResponse cart : cartList){

    }
    
    //구매 및 구매항목 생성
    Purchase purchase = new Purchase();

    //장바구니 비우기



  }


}
