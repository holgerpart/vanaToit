package com.bcs.vanaToit.service.food;

import lombok.Data;

@Data
public class ShopFoodStockRequest {
    private Integer shopId;
    private  String articleName;
}
