package com.bcs.vanaToit.domain.shopfood;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;
import java.time.LocalDate;

@Data
public class ShopFoodDto implements Serializable {
    private final Integer id;
    private final Integer shopId;
    private final String shopName;
    private final Integer foodId;
    private final String foodName;
    private final Integer quantity;
    private final Integer unitId;
    private final String unitName;
    private final Instant dateTime;
    private final LocalDate expirationDate;
    private final String comments;
}
