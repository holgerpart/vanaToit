package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private FoodService foodService;

    @PostMapping("/article")
    @Operation(summary = "Artikli lisamine")
    public void addArticle(@RequestBody ArticleRequest request) {
        foodService.addArticle(request);
    }

    @PostMapping
    @Operation(summary = "Kaubarea lisamine")
    public void addFood(@RequestBody FoodRequest request) {
        foodService.addFood(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Väljasta poe laoseis")
    public List<ShopFoodDto> getStockByShop(ShopFoodRequest request) {
        return foodService.getStockByShop(request);
    }

    @GetMapping("/shopid")
    @Operation(summary = "Väljasta poe laoseis poe Id järgi")
    public List<ShopFoodDto> getStockByShopId(ShopFoodRequestById request) {
        return foodService.getStockByShopId(request);
    }

    @PostMapping("/bookfood")
    @Operation(summary = "Broneeringu lisamine ")
    public void addBookFood(@RequestBody BookFoodRequest request) {
        foodService.addBook(request);
    }

    @GetMapping("/cityname")
    @Operation(summary = "Linna järgi toote leidnmine")
    public List<ShopFoodDto> findShopFoodByCity(CityRequest request){

        return foodService.findShopFoodByCity(request);
    }

    @GetMapping("/shops")
    public List<AuthorizedUserDto> getAuthorizedShops(@RequestParam Integer userId) {
        return foodService.getAuthorizedShops(userId);
    }

    @GetMapping("/articlename")
    @Operation(summary="Tootenimetuse järgi toodete leidmine ")
    public List<ShopFoodDto> findShopFoodByFoodArticle(FoodArticleRequest request){
        return foodService.findShopFoodByFoodArticle(request);
    }
    @GetMapping("/typename")
    @Operation(summary= "toote tüübi järgi toodete leidmine")
    public List<ShopFoodDto>findShopFoodByFoodType(FoodTypeRequest request){
        return foodService.findShopFoodByFoodType(request);
    }

    @PostMapping("/shopfoodquantity")
    @Operation(summary = "Id järgi kaubakoguse muutmine")
    public void updateShopFoodById(FoodIdRequest request){
        foodService.updateShopFoodById(request);
    }
}
