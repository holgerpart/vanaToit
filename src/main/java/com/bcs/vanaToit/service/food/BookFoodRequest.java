package com.bcs.vanaToit.service.food;

import lombok.Data;

@Data
public class BookFoodRequest {

    private Integer userId;

    private Integer shopFoodId;

    private Integer quantity;

}
