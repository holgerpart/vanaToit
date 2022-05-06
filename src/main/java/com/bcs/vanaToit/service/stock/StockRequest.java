package com.bcs.vanaToit.service.stock;

import lombok.Data;

@Data
public class StockRequest {
    private Integer shopId;
    private  String articleName;
}
