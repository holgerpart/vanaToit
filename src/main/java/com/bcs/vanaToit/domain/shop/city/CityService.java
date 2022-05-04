package com.bcs.vanaToit.domain.shop.city;

import com.bcs.vanaToit.service.login.ShopRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;


    public City getCity(ShopRequest request) {
        return cityRepository.findByNameIgnoreCase(request.getCityName());
    }
}
