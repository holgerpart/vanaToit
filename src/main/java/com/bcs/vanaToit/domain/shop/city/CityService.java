package com.bcs.vanaToit.domain.shop.city;

import com.bcs.vanaToit.service.login.ShopRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CityService {

    @Resource
    private CityRepository cityRepository;

    @Resource
    private CityMapper cityMapper;

    public City getCity(ShopRequest request) {
        return cityRepository.findByName(request.getCityName());
    }

    public List<String> getCities() {
        List<City> cities = cityRepository.findAll();
        List<String> cityNames = new ArrayList<>();
        for (City city : cities) {
            cityNames.add(city.getName());
        }
        return cityNames;
//        return cityMapper.toDtos(cityRepository.findAll());
    }
}
