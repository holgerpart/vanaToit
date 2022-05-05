package com.bcs.vanaToit.domain.shop.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query("select (count(s) > 0) from Shop s where upper(s.name) = upper(?1)")
    boolean existsByName(String name);
    @Query("select s from Shop s where s.profile.id = ?1")
    List<Shop> findByProfile(List profileId);

}