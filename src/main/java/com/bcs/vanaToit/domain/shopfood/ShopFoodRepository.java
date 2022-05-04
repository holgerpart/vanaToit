package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.food.food.Food;
import com.bcs.vanaToit.domain.shop.shop.Shop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface ShopFoodRepository extends JpaRepository<ShopFood, Integer> {
    @Query("select s from ShopFood s where upper(s.shop.name) = upper(?1)")
    ShopFood findByShopName(String name);

    @Query("select s from ShopFood s where upper(s.shop.name) = upper(?1)")
    List<ShopFood> findAllByShopName(String name);

    @Query("select s from ShopFood s where s.shop.id = ?1 and s.food.id = ?2")
    Optional<ShopFood> findShopFood(Integer shopId, Integer foodId);

    @Query("select s from ShopFood s where s.shop.id = ?1")
    List<ShopFood> findByShopId(Integer id);

    @Query("select s from ShopFood s where upper(s.shop.profile.city.name) = upper(?1)")
    List<ShopFood> findByCity(String city);

    @Query("select s from ShopFood s where upper(s.food.name) = upper(?1)")
    List<ShopFood> findByFoodName(String name);

    @Transactional
    @Modifying
    @Query("update ShopFood s set s.quantity = ?1 where upper(s.shop) = upper(?2) and upper(s.food) = upper(?3)")
    void updateQuantityByShopAndFood(Integer quantity, Shop shop, Food food);
}