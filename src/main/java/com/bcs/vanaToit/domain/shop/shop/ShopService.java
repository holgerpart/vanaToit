package com.bcs.vanaToit.domain.shop.shop;

import com.bcs.vanaToit.domain.shop.city.CityService;
import com.bcs.vanaToit.domain.shop.profile.Profile;
import com.bcs.vanaToit.domain.shop.profile.ProfileService;
import com.bcs.vanaToit.service.login.ShopRequest;
import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopService {

    @Resource
    private ShopRepository shopRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private ProfileService profileService;

    public void addShop(ShopRequest request) {
        validationService.shopExists(request);
        Profile profile = profileService.addProfile(request);
        Shop shop = new Shop();
        shop.setName(request.getShopName());
        shop.setProfile(profile);
        shopRepository.save(shop);
    }
}
