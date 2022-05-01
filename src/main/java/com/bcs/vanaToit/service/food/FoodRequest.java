package com.bcs.vanaToit.service.food;

import lombok.Data;

import java.util.Date;

@Data
public class FoodRequest {

    private Integer shopId;

    private Integer foodId;

    private Integer quantity;

    private Date expirationDate;
}
