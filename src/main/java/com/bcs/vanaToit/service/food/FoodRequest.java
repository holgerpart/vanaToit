package com.bcs.vanaToit.service.food;

import com.bcs.vanaToit.domain.food.unit.Unit;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
public class FoodRequest {

    private Integer shopId;

    private Integer foodId;

    private Integer quantity;

    private LocalDate expirationDate;

    private String comments;

    private String unit;

}
