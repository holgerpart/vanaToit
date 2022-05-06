package com.bcs.vanaToit.service.order;

import com.bcs.vanaToit.domain.transaction.bookfood.BookFoodDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping
public class OrderController {

    @Resource
    private OrderService orderService;

    @PostMapping("/bookfood")
    @Operation(summary = "Broneeringu lisamine")
    public void addBookFood(@RequestBody BookFoodRequest request) {
        orderService.addBookFood(request);
    }

    @GetMapping("/bookfoods")
    @Operation(summary = "/Näita kõiki broneeringuid")
    public List<BookFoodDto> getBookFoods() {
        return orderService.getBookFoods();
    }

    @GetMapping("/foods")
    @Operation(summary = "Leia broneeringud poe id järgi")
    public List<BookFoodDto> findAllActiveOrdersByShopId(@RequestParam Integer shopId) {
        return orderService.findAllActiveOrdersByShopId(shopId);
    }

}
