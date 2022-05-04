package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.food.food.FoodRepository;
import com.bcs.vanaToit.domain.food.unit.UnitRepository;
import com.bcs.vanaToit.domain.shop.shop.ShopRepository;
import com.bcs.vanaToit.service.food.CityRequest;
import com.bcs.vanaToit.service.food.FoodRequest;
import com.bcs.vanaToit.service.food.ShopFoodRequest;
import com.bcs.vanaToit.service.food.ShopFoodRequestById;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.Instant;
import java.util.List;
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

    @Resource
    private ShopFoodMapper shopFoodMapper;

    public void addShopFood(FoodRequest request) {
        Optional<ShopFood> shopFood = shopFoodRepository.findShopFood(request.getShopId(), request.getFoodId());
        ShopFood newFood = new ShopFood();

        if (shopFood.isPresent()) {
            Integer quantity = shopFood.get().getQuantity() + request.getQuantity();
            shopFoodRepository.updateQuantityByShopAndFoodAllIgnoreCase(quantity, shopFood.get().getShop(), shopFood.get().getFood());
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

    public List<ShopFoodDto> getShopFoodByShop(ShopFoodRequest request) {
        List<ShopFood> stock = shopFoodRepository.findAllByShopName(request.getShopName());
        return shopFoodMapper.toDtos(stock);

        }

    public List<ShopFoodDto> findShopFoodByCity(CityRequest request) {
        List<ShopFood> shopFoods = shopFoodRepository.findAllByShopName(request.getCity());
        return shopFoodMapper.toDtos(shopFoods);
    }

    public List<ShopFoodDto> getStockByShopId(ShopFoodRequestById request) {
        List<ShopFood> stock = shopFoodRepository.findByShopId(request.getShopId());
        return shopFoodMapper.toDtos(stock);
    }
}

