package com.bcs.vanaToit.service.food;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/food")
public class FoodController {

    @Resource
    private FoodService foodService;

    @PostMapping
    @Operation(summary = "Artikli lisamine")
    public void addArticle(@RequestBody ArticleRequest request) {
        foodService.addArticle(request);
    }

}
