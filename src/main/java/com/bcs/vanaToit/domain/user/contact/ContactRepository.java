package com.bcs.vanaToit.domain.user.contact;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface ContactRepository extends JpaRepository<Contact, Integer> {
    @Transactional
    @Modifying
    @Query("delete from Contact c where upper(c.firstName) = upper(?1) and upper(c.lastName) = upper(?2)")
    void deleteByName(String firstName, String lastName);


}