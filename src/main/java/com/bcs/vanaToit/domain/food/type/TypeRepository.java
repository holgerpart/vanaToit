package com.bcs.vanaToit.domain.food.type;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface TypeRepository extends JpaRepository<Type, Integer> {
    @Query("select t from Type t where upper(t.name) = upper(?1)")
    Type findType(String name);

    @Query("select (count(t) > 0) from Type t where upper(t.name) = upper(?1)")
    boolean existsByName(String name);
}