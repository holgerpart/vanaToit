package com.bcs.vanaToit.service.order;

import com.bcs.vanaToit.domain.transaction.bookfood.BookFood;
import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodDto;
import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodMapper;
import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class OrderService {

    @Resource
    private BookFoodService bookFoodService;

    @Resource
    private BookFoodMapper bookFoodMapper;

    public void addBookFood(OrderRequest request) {
        bookFoodService.addBookFood(request);
    }

    public List<BookFoodDto> getBookFoods() {
        return bookFoodService.getBookFoods();
    }

    public List<BookFoodDto> findAllActiveOrdersByShopId(Integer shopId) {
        List<BookFood> foods = bookFoodService.findAllActiveOrdersByShopId(shopId);
        return bookFoodMapper.toDtos(foods);
    }

    public List<BookFoodDto> findAllActiveOrderByCustomerId(Integer userId) {
        List<BookFood> foods = bookFoodService.findAllActiveOrderByCustomerId(userId);
        return bookFoodMapper.toDtos(foods);
    }

    public void updateOrder(OrderUpdateRequest request) {
        bookFoodService.updateOrder(request);
    }

    public void updateStatus(StatusUpdateRequest request) {
        bookFoodService.updateStatus(request);
    }
}
