package com.bcs.vanaToit.service.stock;

import com.bcs.vanaToit.domain.food.food.ArticleService;
import com.bcs.vanaToit.domain.food.food.FoodDto;
import com.bcs.vanaToit.domain.food.type.TypeDto;
import com.bcs.vanaToit.domain.food.type.TypeService;
import com.bcs.vanaToit.domain.shop.shop.ShopDto;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import com.bcs.vanaToit.domain.shopfood.ShopFoodService;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUser;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserDto;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserMapper;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class StockService {

    @Resource
    private ArticleService articleService;

    @Resource
    private ShopFoodService shopFoodService;

    @Resource
    private AuthorizedUserService authorizedUserService;

    @Resource
    private AuthorizedUserMapper authorizedUserMapper;

    @Resource
    private TypeService typeService;

    public void addArticle(ArticleRequest request) {
        articleService.addArticle(request);
    }

    public void addShopFood(FoodRequest request) {
        shopFoodService.addShopFood(request);
    }

    public void addStockByName(StockNameRequest request) {
        shopFoodService.addStockByName(request);
    }

    public List<ShopFoodDto> getShopFoodByShop(String shop) {
        return shopFoodService.getShopFoodByShop(shop);
    }

    public List<ShopFoodDto> findShopFoodByCity(String city) {
        return shopFoodService.findShopFoodByCity(city);
    }

    public List<ShopFoodDto> getStockByShopId(Integer shopId) {
        return shopFoodService.getStockByShopId(shopId);
    }

    public List<AuthorizedUserDto> getAuthorizedShops(Integer userId) {
        List<AuthorizedUser> authorizedShops = authorizedUserService.getAuthorizedShops(userId);
        return authorizedUserMapper.toDtos(authorizedShops);
    }

    public List<ShopFoodDto> findShopFoodByFoodArticle(String article) {
        return shopFoodService.findShopFoodByFoodArticle(article);

    }

    public List<ShopFoodDto> findShopFoodByFoodType(String type) {
        return shopFoodService.findShopFoodByFoodType(type);
    }

    public void updateShopFoodById(FoodIdRequest request) {
        shopFoodService.updateShopFoodById(request);
    }

    public List<ShopFoodDto> getItemStockByShopId(StockRequest request) {
        return shopFoodService.getItemStockByShopId(request);
    }

    public List<FoodDto> getArticles() {
        return articleService.getArticles();
    }

    public List<TypeDto> getTypes() {
        return typeService.getTypes();
    }
}
