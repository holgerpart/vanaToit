package com.bcs.vanaToit.service.stock;

import lombok.Data;

@Data
public class StockResponse {

    private Integer shopFoodId;

    private String food;

    private Integer quantity;

    private String unit;

}
