package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.food.ArticleService;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import com.bcs.vanaToit.domain.shopfood.ShopFoodService;
import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodService {

    @Resource
    private BookFoodService bookFoodService;

    @Resource
    private ArticleService articleService;

    @Resource
    private ShopFoodService shopFoodService;

    public void addArticle(ArticleRequest request) {
        articleService.addArticle(request);
    }

    public void addFood(FoodRequest request) {
        shopFoodService.addFood(request);
    }

    public List<ShopFoodDto> getStockByShop(StockRequest request) {
        return shopFoodService.getStockByShop(request);
    }

    public void addBook(BookRequest request) {
        bookFoodService.addBookFood(request);
    }
}
