package com.bcs.vanaToit.domain.transaction.bookfood;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface BookFoodRepository extends JpaRepository<BookFood, Integer> {
    @Query("select b from BookFood b where b.shopFood.shop.id = ?1")
    List<BookFood> getBookFoods(Integer shopId);

    @Query("select b from BookFood b where b.user.id = ?1")
    List<BookFood>getCustomerBookedFoods (Integer userId);

}