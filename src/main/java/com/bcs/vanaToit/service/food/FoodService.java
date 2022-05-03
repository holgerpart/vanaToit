package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.food.ArticleService;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import com.bcs.vanaToit.domain.shopfood.ShopFoodService;
import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodService;
import com.bcs.vanaToit.domain.user.authorized.*;
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

    @Resource
    private AuthorizedUserService authorizedUserService;

    @Resource
    private AuthorizedUserMapper authorizedUserMapper;

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

    public List<ShopFoodDto> getStockByShopId(StockRequestById request) {
        return shopFoodService.getStockByShopId(request);
    }

    public List<AuthorizedUserDto> getAuthorizedShops(Integer userId) {
        List<AuthorizedUser> authorizedShops = authorizedUserService.getAuthorizedShops(userId);
        return authorizedUserMapper.toDtos(authorizedShops);
    }
}
