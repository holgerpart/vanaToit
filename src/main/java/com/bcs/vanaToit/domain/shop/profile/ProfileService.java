package com.bcs.vanaToit.domain.shop.profile;


import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProfileService {

    @Resource ProfileRepository profileRepository;

    public List<Profile> getProfileId(Integer cityId){
        List<Profile> profileId = profileRepository.findByCityId(cityId);
        return profileId;
    }

}
