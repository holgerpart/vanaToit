package com.bcs.vanaToit.domain.shop.city;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    public Integer getCityId(String cityName){
        City city = cityRepository.findByNameIgnoreCase(cityName);
        Integer cityId = city.getId();
        return cityId;

    }



}
