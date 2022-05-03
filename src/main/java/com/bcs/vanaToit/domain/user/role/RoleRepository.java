package com.bcs.vanaToit.domain.user.role;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface RoleRepository extends JpaRepository<Role, Integer> {
    @Query("select r from Role r where upper(r.role) = upper(?1)")
    Role findByRole(String role);
}