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

    @Resource
    private ShopMapper shopMapper;

    public void addShop(ShopRequest request) {
        validationService.shopExists(request);
        Profile profile = profileService.addProfile(request);
        Shop shop = new Shop();
        shop.setName(request.getShopName());
        shop.setProfile(profile);
        shopRepository.save(shop);
    }

    public List<ShopDto> getShops() {
        return shopMapper.toDtos(shopRepository.findAll());
    }

    public void updateShop(ShopDto request) {
        Profile profile = profileService.updateProfile(request);
        Shop shop = shopRepository.getById(request.getId());
        shop.setProfile(profile);
        shop.setName(request.getName());
        shopRepository.save(shop);
    }
}
