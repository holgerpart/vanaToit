package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.food.ArticleService;
import com.bcs.vanaToit.domain.shopfood.ShopFoodService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FoodService {

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

    public List<StockResponse> getStock(StockRequest request) {
        shopFoodService.getStock(request);
    }
}
