package com.bcs.vanaToit.service.order;

import lombok.Data;

@Data
public class StatusUpdateRequest {
    private Integer orderId;
    private String statusName;
}
