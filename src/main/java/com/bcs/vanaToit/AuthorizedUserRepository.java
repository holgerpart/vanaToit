package com.bcs.vanaToit;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedUserRepository extends JpaRepository<AuthorizedUser, Integer> {
}