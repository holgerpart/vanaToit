package com.bcs.vanaToit.domain.food.unit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UnitRepository extends JpaRepository<Unit, Integer> {
    @Query("select u from Unit u where upper(u.name) = upper(?1)")
    Unit findUnit(String name);
}