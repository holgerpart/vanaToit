package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopFoodRepository extends JpaRepository<ShopFood, Integer> {
    @Query("select s from ShopFood s where upper(s.shop.name) = upper(?1)")
    ShopFood findByShopName(String name);

    @Query("select s from ShopFood s where upper(s.shop.name) = upper(?1)")
    List<ShopFood> findAllByShopName(String name);

    @Query("select s from ShopFood s where s.shop.id = ?1 and s.food.id = ?2")
    Optional<ShopFood> findShopFood(Integer shopId, Integer foodId);
}