package com.bcs.vanaToit.domain.transaction.bookfood;

import com.bcs.vanaToit.domain.food.food.Food;
import com.bcs.vanaToit.domain.shop.shop.Shop;
import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodRepository;
import com.bcs.vanaToit.domain.transaction.Status;
import com.bcs.vanaToit.domain.transaction.StatusRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.service.food.BookFoodRequest;
import com.bcs.vanaToit.service.food.BookFoodRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class BookFoodService {

    @Resource
    private ShopFoodRepository shopFoodRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private BookFoodRepository bookFoodRepository;

    @Resource
    private StatusRepository statusRepository;

    public void addBookFood(BookFoodRequest request) {
        BookFood bookFood = new BookFood();
        ShopFood shopFood = shopFoodRepository.getById(request.getShopFoodId());
        Integer quantity = shopFood.getQuantity() - request.getQuantity();
        Status status = statusRepository.getById(3);
        User user = userRepository.getById(request.getUserId());
        bookFood.setShopFood(shopFood);
        bookFood.setUser(user);
        bookFood.setQuantity(request.getQuantity());
        bookFood.setStatus(status);
        Integer id = shopFood.getId();
        bookFoodRepository.save(bookFood);
        shopFoodRepository.updateQuantityById(quantity, id);
    }

    public List<BookFood> findAllActiveOrdersByShopId(Integer shopId) {
        return bookFoodRepository.getBookFoods(shopId);
    }
}
