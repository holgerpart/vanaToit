package com.bcs.vanaToit.domain.food.food;

import lombok.Data;

import java.io.Serializable;

@Data
public class FoodDto implements Serializable {
    private final Integer id;
    private final String name;
}
