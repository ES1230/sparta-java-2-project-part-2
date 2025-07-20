package com.sparta.shopping.domain.cart.repository;

import com.sparta.shopping.domain.cart.entity.Cart;
import com.sparta.shopping.domain.product.entity.Product;
import com.sparta.shopping.domain.user.entity.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

  Optional<Cart> findByUserAndProductAndDelYn(User user, Product product, String delYn);

  List<Cart> findAllByUserAndDelYn(User user, String delYn);

}
