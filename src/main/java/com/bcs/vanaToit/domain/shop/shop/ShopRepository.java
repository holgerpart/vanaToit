package com.bcs.vanaToit.domain.shop.shop;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ShopRepository extends JpaRepository<Shop, Integer> {
    @Query("select s from Shop s where s.profile.id = ?1")
    List<Shop> findByProfile(List profileId);


}