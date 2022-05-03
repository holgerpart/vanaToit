package com.bcs.vanaToit.service.login;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShopRequest {
    private String shopName;

    private String aadress;

    private String telNumber;

    private BigDecimal longitude;

    private BigDecimal latitude;

    private String cityName;
}
