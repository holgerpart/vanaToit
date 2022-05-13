package com.bcs.vanaToit.domain.transaction.bookfood;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodRepository;
import com.bcs.vanaToit.domain.transaction.status.Status;
import com.bcs.vanaToit.domain.transaction.status.StatusRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.service.order.OrderRequest;
import com.bcs.vanaToit.service.order.OrderUpdateRequest;
import com.bcs.vanaToit.service.order.StatusUpdateRequest;
import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Objects;

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

    @Resource
    private ValidationService validationService;

    public void addBookFood(OrderRequest request) {
        validationService.validQuantity(request);
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
        validationService.validUpdateQuantity(request);
        BookFood order = bookFoodRepository.getById(request.getOrderId());
        ShopFood shopFood = shopFoodRepository.getById(order.getShopFood().getId());
        Integer difference = order.getQuantity() - request.getQuantity();
        order.setQuantity(request.getQuantity());
        bookFoodRepository.save(order);
        Integer newStockQuantity = shopFood.getQuantity() + difference;
        shopFood.setQuantity(newStockQuantity);
        shopFoodRepository.save(shopFood);
        bookFoodMapper.toDto(order);
    }

    public void updateStatus(StatusUpdateRequest request) {
        BookFood order = bookFoodRepository.getById(request.getOrderId());
        validationService.validStatus(order.getStatus());
        Status status = statusRepository.findByDescription(request.getStatusName());
        order.setStatus(status);
        bookFoodRepository.save(order);
        if (Objects.equals(request.getStatusName(), "Cancelled")) {
            cancelOrder(request, order);
        }
    }

    private void cancelOrder(StatusUpdateRequest request, BookFood order) {
        Integer quantity = order.getQuantity();
        ShopFood shopFood = order.getShopFood();
        quantity = quantity + shopFood.getQuantity();
        shopFood.setQuantity(quantity);
        shopFoodRepository.save(shopFood);

    }
}
