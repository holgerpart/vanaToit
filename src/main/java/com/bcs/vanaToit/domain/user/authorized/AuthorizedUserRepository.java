package com.bcs.vanaToit.domain.user.authorized;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorizedUserRepository extends JpaRepository<AuthorizedUser, Integer> {
    @Query("select a from AuthorizedUser a where a.user.id = ?1")
    AuthorizedUser findByUserId(Integer id);

    @Query("select a from AuthorizedUser a where a.user.id = ?1 order by a.shop.name")
    List<AuthorizedUser> findUserAuthorizedShops(Integer userId);


}