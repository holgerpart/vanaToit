package com.bcs.vanaToit.domain.shop.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface CityRepository extends JpaRepository<City, Integer> {
    @Query("select c from City c where upper(c.name) = upper(?1)")
    City findByNameIgnoreCase(String name);
}