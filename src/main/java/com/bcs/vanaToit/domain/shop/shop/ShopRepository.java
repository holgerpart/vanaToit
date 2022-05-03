package com.bcs.vanaToit.domain.shop.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query("select s from Shop s where s.profile.id = ?1")
    List<Shop> findByProfile(List profileId);

    @Query("select s from Shop s where s.profile.city.name = ?1")
    List<Shop> findByProfile_City_Name(String name);

}