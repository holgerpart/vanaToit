package com.bcs.vanaToit.domain.shop.profile;


import com.bcs.vanaToit.domain.shop.city.CityService;
import com.bcs.vanaToit.domain.shop.shop.Shop;
import com.bcs.vanaToit.domain.shop.shop.ShopDto;
import com.bcs.vanaToit.domain.shop.shop.ShopRepository;
import com.bcs.vanaToit.domain.shop.shop.ShopService;
import com.bcs.vanaToit.service.login.ShopRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ProfileService {

    @Resource
    private ProfileRepository profileRepository;

    @Resource
    private CityService cityService;

    @Resource
    private ShopRepository shopRepository;

    public Profile addProfile(ShopRequest request) {
        Profile profile = new Profile();
        profile.setAadress(request.getAadress());
        profile.setCity(cityService.getCity(request));
        profile.setTelNumber(request.getTelNumber());
        profile.setLongitude(request.getLongitude());
        profile.setLatitude(request.getLatitude());
        profileRepository.save(profile);
        return profileRepository.findByAadress(request.getAadress());
    }

    public Profile updateProfile(ShopDto request) {
        Profile profile = shopRepository.getById(request.getId()).getProfile();
        profile.setAadress(request.getAadress());
        profile.setTelNumber(request.getTelNumber());
        profileRepository.save(profile);
        return profile;
    }
}
