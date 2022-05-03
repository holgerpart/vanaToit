package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodDto;
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

    @PostMapping("/add")
    @Operation(summary = "Kaubarea lisamine")
    public void addFood(@RequestBody FoodRequest request) {
        foodService.addFood(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Väljasta poe laoseis")
    public List<ShopFoodDto> getStockByShop(StockRequest request) {
        return foodService.getStockByShop(request);
    }

    @PostMapping("/booking")
    @Operation(summary = "Tellimuse lisamine")
    public void addBook(@RequestBody BookRequest request) {
        foodService.addBook(request);
    }

}
