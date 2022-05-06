package com.bcs.vanaToit.service.stock;

import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/stock")
public class StockController {

    @Resource
    private StockService stockService;

    @PostMapping("/article")
    @Operation(summary = "Toidu artikli lisamine")
    public void addFoodArticle(@RequestBody ArticleRequest request) {
        stockService.addArticle(request);
    }

    @PostMapping
    @Operation(summary = "Kaubarea lisamine")
    public void addStock(@RequestBody FoodRequest request) {
        stockService.addShopFood(request);
    }

    @PostMapping("/stock")
    @Operation(summary = "Id järgi kaubakoguse muutmine")
    public void updateStockById(@RequestBody FoodIdRequest request) {
        stockService.updateShopFoodById(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Väljasta poe laoseis")
    public List<ShopFoodDto> getStockByShop(String shop) {
        return stockService.getShopFoodByShop(shop);
    }

    @GetMapping("/shopid")
    @Operation(summary = "Väljasta poe laoseis poe Id järgi")
    public List<ShopFoodDto> getStockByShopId(Integer shopId) {
        return stockService.getStockByShopId(shopId);
    }

    @GetMapping("/cityname")
    @Operation(summary = "Linna järgi toodete leidnmine")
    public List<ShopFoodDto> findStockByCity(String city) {
        return stockService.findShopFoodByCity(city);
    }

    @GetMapping("/shops")
    @Operation(summary = "Kasutaja autoriseeritud poodide leidmine")
    public List<AuthorizedUserDto> getAuthorizedShops(@RequestParam Integer userId) {
        return stockService.getAuthorizedShops(userId);
    }

    @GetMapping("/articlename")
    @Operation(summary = "Tootenimetuse järgi toodete leidmine ")
    public List<ShopFoodDto> findStockByFoodArticle(String article) {
        return stockService.findShopFoodByFoodArticle(article);
    }

    @GetMapping("/typename")
    @Operation(summary = "Toote tüübi järgi toodete leidmine")
    public List<ShopFoodDto> findStockByFoodType(String type) {
        return stockService.findShopFoodByFoodType(type);
    }

    @GetMapping("/stock")
    @Operation(summary = "Väljasta ühe toote laoseis poe Id ja toote järgi")
    public List<ShopFoodDto> getItemStockByShopId(StockRequest request) {
        return stockService.getItemStockByShopId(request);
    }
}

