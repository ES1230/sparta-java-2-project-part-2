package com.sparta.shopping.domain.cart.service;

import com.sparta.shopping.common.exception.ServiceException;
import com.sparta.shopping.common.exception.ServiceExceptionCode;
import com.sparta.shopping.domain.cart.dto.CartResponse;
import com.sparta.shopping.domain.cart.entity.Cart;
import com.sparta.shopping.domain.cart.repository.CartRepository;
import com.sparta.shopping.domain.product.entity.Product;
import com.sparta.shopping.domain.product.repository.ProductRepository;
import com.sparta.shopping.domain.user.entity.User;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CartService {

  private final CartRepository cartRepository;
  private final ProductRepository productRepository;

  @Transactional
  public void addCartItem(User user, Long productId, int quantity){
    Product product = productRepository.findById(productId)
        .orElseThrow(()->new ServiceException(ServiceExceptionCode.NOT_FOUND_PRODUCT));

    //기존 장바구니 항목 있는지 확인
    Optional<Cart>  optionalCart = cartRepository.findByUserAndProductAndDelYn(user,product, "N");

    if(optionalCart.isPresent()){
      Cart cart = optionalCart.get();
      cart.setQuantity(cart.getQuantity()+quantity);
    }else{
      Cart newCart = Cart.builder()
          .user(user)
          .product(product)
          .quantity(quantity)
          .build();
      cartRepository.save(newCart);
    }
  }

  @Transactional(readOnly = true)
  public List<CartResponse> getCartItems(User user){

    List<Cart> cartList = cartRepository.findAllByUserAndDelYn(user,"N");

    return cartList.stream()
        .map(cart->CartResponse.builder()
            .id(cart.getId())
            .productId(cart.getProduct().getId())
            .productName(cart.getProduct().getName())
            .productPrice(cart.getProduct().getPrice())
            .quantity(cart.getQuantity())
            .createdAt(cart.getCreatedAt())
            .build())
        .collect(Collectors.toList());
  }

  @Transactional
  public void deleteCartItem(User user, Long cartItemId){

    Cart cartItem = cartRepository.findById(cartItemId)
        .orElseThrow(()->new ServiceException(ServiceExceptionCode.NOT_FOUND_CART_ITEM));

    if (!cartItem.getUser().getId().equals(user.getId())) {
      throw new ServiceException(ServiceExceptionCode.UNAUTHORIZED);
    }

    cartItem.setDelYn("Y");
    cartItem.setDeletedAt(LocalDateTime.now());
    cartRepository.save(cartItem);
  }


}
