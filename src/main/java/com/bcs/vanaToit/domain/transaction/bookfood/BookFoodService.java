package com.bcs.vanaToit.domain.transaction.bookfood;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodRepository;
import com.bcs.vanaToit.domain.transaction.status.Status;
import com.bcs.vanaToit.domain.transaction.status.StatusRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.service.order.BookFoodRequest;
import com.bcs.vanaToit.service.order.OrderUpdateRequest;
import com.bcs.vanaToit.service.order.StatusUpdateRequest;
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

    @Resource
    private BookFoodMapper bookFoodMapper;

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

    public List<BookFoodDto> getBookFoods() {
        List<BookFood> list = bookFoodRepository.findAll();
        return bookFoodMapper.toDtos(list);
    }

    public List<BookFood> findAllActiveOrdersByShopId(Integer shopId) {
        return bookFoodRepository.getBookFoods(shopId);
    }

    public List<BookFood> findAllActiveOrderByCustomerId(Integer userId) {
        return bookFoodRepository.getCustomerBookedFoods(userId);
    }

    public void updateOrder(OrderUpdateRequest request) {
        BookFood order = bookFoodRepository.getById(request.getOrderId());
        Integer difference = order.getQuantity() - request.getQuantity();
        order.setQuantity(request.getQuantity());
        bookFoodRepository.save(order);
        ShopFood shopFood = shopFoodRepository.getById(order.getShopFood().getId());
        Integer newStockQuantity = shopFood.getQuantity() + difference;
        shopFood.setQuantity(newStockQuantity);
        shopFoodRepository.save(shopFood);
        bookFoodMapper.toDto(order);
    }

    public void updateStatus(StatusUpdateRequest request) {
        BookFood order = bookFoodRepository.getById(request.getOrderId());
        Status status = statusRepository.findByDescription(request.getStatusName());
        order.setStatus(status);
        bookFoodRepository.save(order);
    }
}
