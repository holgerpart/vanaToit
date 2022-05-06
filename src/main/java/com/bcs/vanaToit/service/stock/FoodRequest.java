package com.bcs.vanaToit.service.stock;

import lombok.Data;

import java.time.LocalDate;

@Data
public class FoodRequest {

    private Integer shopId;

    private Integer foodId;

    private Integer quantity;

    private LocalDate expirationDate;

    private String comments;

    private String unit;

}
