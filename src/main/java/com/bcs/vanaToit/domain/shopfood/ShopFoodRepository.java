package com.bcs.vanaToit.domain.shopfood;

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

    @Query("select s from ShopFood s where s.shop.id = ?1")
    List<ShopFood> findByShopId(Integer id);

    @Query("select s from ShopFood s where upper(s.shop.profile.city.name) = upper(?1)")
    List<ShopFood> findByCity(String city);

    @Query("select s from ShopFood s where upper(s.food.name) = upper(?1)")
    List<ShopFood> findByFoodName(String name);

    @Query("select s from ShopFood s where upper(s.food.name) = upper(?1)")
    List<ShopFood> findShopsByFoodName(String name);

    @Query("select s from ShopFood s where upper(s.food.type.name) = upper(?1)")
    List<ShopFood> findByFoodByTypeName(String name);


}