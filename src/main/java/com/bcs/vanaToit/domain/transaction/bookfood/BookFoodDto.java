package com.bcs.vanaToit.domain.transaction.bookfood;

import lombok.Data;

import java.io.Serializable;

@Data
public class BookFoodDto implements Serializable {
    private final Integer id;
    private final String firstName;
    private final String lastName;
    private final String shopName;
    private final String foodName;
    private final Integer quantity;
    private final String status;
}
