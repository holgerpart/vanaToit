package com.bcs.vanaToit.domain.user.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByNameAndPassword(String name, String password);

}