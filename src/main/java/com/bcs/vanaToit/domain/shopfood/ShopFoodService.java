package com.bcs.vanaToit.domain.shopfood;

import com.bcs.vanaToit.domain.food.food.Food;
import com.bcs.vanaToit.domain.food.food.FoodRepository;
import com.bcs.vanaToit.domain.food.unit.UnitRepository;
import com.bcs.vanaToit.domain.shop.city.City;
import com.bcs.vanaToit.domain.shop.city.CityRepository;
import com.bcs.vanaToit.domain.shop.shop.ShopRepository;
import com.bcs.vanaToit.service.stock.*;
import com.bcs.vanaToit.validation.ValidationService;
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

    @Resource
    private CityRepository cityRepository;

    @Resource
    ValidationService validationService;

    public void addShopFood(FoodRequest request) {
        Optional<ShopFood> shopFood = shopFoodRepository.findShopFood(request.getShopId(), request.getFoodId());
        ShopFood newFood = new ShopFood();
        if (shopFood.isPresent()) {
            Integer quantity = shopFood.get().getQuantity() + request.getQuantity();
            String comments = shopFood.get().getComments();
            validationService.positiveQuantity(quantity);
//            shopFoodRepository.updateQuantityById(quantity, shopFood.get().getId());
            shopFoodRepository.updateCommentsAndQuantityById(comments, quantity, shopFood.get().getId());

        } else {
            validationService.positiveQuantity(request.getQuantity());
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

    public void addStockByName(StockNameRequest request) {
        Food food = foodRepository.findByName(request.getFoodName());
        Optional<ShopFood> shopFood = shopFoodRepository.findShopFood(request.getShopId(), food.getId());
        ShopFood newFood = new ShopFood();
        if (shopFood.isPresent()) {
            Integer quantity = shopFood.get().getQuantity() + request.getQuantity();
            validationService.positiveQuantity(quantity);
            String comments = shopFood.get().getComments();
//            shopFoodRepository.updateQuantityById(quantity, shopFood.get().getId());
            shopFoodRepository.updateCommentsAndQuantityById(comments, quantity, shopFood.get().getId());
        } else {
            validationService.positiveQuantity(request.getQuantity());
            newFood.setFood(foodRepository.getById(food.getId()));
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

    public List<ShopFoodDto> getShopFoodByShop(String shop) {
        List<ShopFood> stock = shopFoodRepository.findAllByShopName(shop);
        return shopFoodMapper.toDtos(stock);

        }

    public List<ShopFoodDto> findShopFoodByCity(String city) {
//        City request = cityRepository.findByNameIgnoreCase(city);
        List<ShopFood> shopFoods = shopFoodRepository.findByCity(city);
        return shopFoodMapper.toDtos(shopFoods);
    }

    public List<ShopFoodDto> getStockByShopId(Integer shopId) {
        List<ShopFood> stock = shopFoodRepository.findByShopId(shopId);
        return shopFoodMapper.toDtos(stock);
    }

    public List<ShopFoodDto> findShopFoodByFoodArticle(String article) {
        List<ShopFood> shopFoods =shopFoodRepository.findShopsByFoodName(article);
        return shopFoodMapper.toDtos(shopFoods);
    }

    public List<ShopFoodDto> findShopFoodByFoodType(String type) {
        List<ShopFood> shopFoods = shopFoodRepository.findByFoodByTypeName(type);
        return shopFoodMapper.toDtos(shopFoods);
    }

    public void updateShopFoodById(FoodIdRequest request) {
        validationService.positiveQuantity(request.getQuantity());
        shopFoodRepository.updateQuantityById(request.getQuantity(),request.getFoodId());
    }

    public List<ShopFoodDto> getItemStockByShopId(StockRequest request) {
        List<ShopFood> stock = shopFoodRepository.getItemStockByShopId(request.getShopId(),request.getArticleName());
        return shopFoodMapper.toDtos(stock);
    }


}

