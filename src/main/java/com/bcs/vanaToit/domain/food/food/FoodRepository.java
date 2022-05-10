package com.bcs.vanaToit.domain.food.food;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FoodRepository extends JpaRepository<Food, Integer> {
    @Query("select (count(f) > 0) from Food f where upper(f.name) = upper(?1)")
    boolean articleExists(String name);

    @Query("select f from Food f where upper(f.name) = upper(?1)")
    Food findByName(String name);


}