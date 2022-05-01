package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.food.food.FoodRepository;
import com.bcs.vanaToit.domain.food.unit.UnitRepository;
import com.bcs.vanaToit.domain.shop.ShopRepository;
import com.bcs.vanaToit.service.food.FoodRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.Optional;

@Service
public class ShopFoodService {

    @Resource
    private ShopFoodRepository shopFoodRepository;

    @Resource
    private FoodRepository foodRepository;

    @Resource
    private ShopRepository shopRepository;

    @Resource
    private UnitRepository unitRepository;

    public void addFood(FoodRequest request) {
        Optional<ShopFood> shopFood = shopFoodRepository.findShopFood(request.getShopId(), request.getFoodId());
        ShopFood newFood = new ShopFood();
        if (shopFood.isPresent()) {
            Integer quantity = shopFood.get().getQuantity() + request.getQuantity();
        } else {
            newFood.setFood(foodRepository.getById(request.getFoodId()));
            newFood.setShop(shopRepository.getById(request.getShopId()));
            newFood.setQuantity(request.getQuantity());
            newFood.setDateTime(Instant.now());
            newFood.setComments(request.getComments());
            newFood.setUnit(unitRepository.findUnit(request.getUnit()));
            newFood.setExpirationDate(request.getExpirationDate());
            newFood.setIsAvailable(true);
            shopFoodRepository.save(newFood);
        }

    }
}
