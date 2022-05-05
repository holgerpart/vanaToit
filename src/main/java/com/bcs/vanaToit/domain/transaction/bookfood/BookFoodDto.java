package com.bcs.vanaToit.domain.transaction.bookfood;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookFoodDto implements Serializable {
    private final Integer id;
    private final Integer userId;
    private final String userContactFirstName;
    private final String userContactLastName;
    private final String shopFoodShopName;
    private final String shopFoodFoodName;
    private final String shopFoodComments;
    private final Integer quantity;
    private final String statusDescription;
}
