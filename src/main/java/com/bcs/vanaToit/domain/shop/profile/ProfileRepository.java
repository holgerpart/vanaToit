package com.bcs.vanaToit.domain.shop.profile;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProfileRepository extends JpaRepository<Profile, Integer> {

    Profile findByAadress(String aadress);





}