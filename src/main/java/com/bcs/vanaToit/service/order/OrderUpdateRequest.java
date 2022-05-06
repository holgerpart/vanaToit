package com.bcs.vanaToit.service.order;

import lombok.Data;

@Data
public class OrderUpdateRequest {
    private Integer orderId;
    private Integer quantity;

}
