package com.bcs.vanaToit.domain.transaction.bookfood;

import com.bcs.vanaToit.domain.shop.shop.Shop;
import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.service.food.BookFoodRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class BookFoodService {

    @Resource
    private ShopFoodRepository shopFoodRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private BookFoodRepository bookFoodRepository;

    public void addBookFood(BookFoodRequest request) {
        BookFood bookFood = new BookFood();
        ShopFood shopFood = shopFoodRepository.getById(request.getShopFoodId());
        Integer quantity = shopFood.getQuantity() - request.getQuantity();
        User user = userRepository.getById(request.getUserId());
        bookFood.setShopFood(shopFood);
        bookFood.setUser(user);
        bookFoodRepository.save(bookFood);
        shopFoodRepository.updateQuantityByShopAndFood(quantity, shopFood.getShop(), shopFood.getFood());
    }
}
