package com.bcs.vanaToit.domain.user.authorized;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizedUserRepository extends JpaRepository<AuthorizedUser, Integer> {
}