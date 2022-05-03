package com.bcs.vanaToit.domain.shop.shop;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ShopService {

    @Resource ShopRepository shopRepository;

    public List<Shop> findShops(List profileId){
        List<Shop> shops = shopRepository.findByProfile(profileId);
        return shops;
    }
}
