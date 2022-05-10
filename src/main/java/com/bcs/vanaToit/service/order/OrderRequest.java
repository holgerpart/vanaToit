package com.bcs.vanaToit.service.order;

import lombok.Data;

@Data
public class OrderRequest {

    private Integer userId;
    private Integer shopFoodId;
    private Integer quantity;

}
