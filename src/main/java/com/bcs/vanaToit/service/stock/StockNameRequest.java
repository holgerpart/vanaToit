package com.bcs.vanaToit.service.stock;

import lombok.Data;

import java.time.LocalDate;

@Data
public class StockNameRequest {

    private Integer shopId;

    private String foodName;

    private Integer quantity;

    private LocalDate expirationDate;

    private String comments;

    private String unit;

}
