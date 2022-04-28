package com.bcs.vanaToit.domain.user.userrole;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole, Integer> {
    @Query("select u from UserRole u where u.user.id = ?1")
    List<UserRole> findByUserId(Integer userId);



}