package com.bcs.vanaToit.domain.shop.shop;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class ShopDto implements Serializable {
    private final Integer id;
    private final String name;
    private final String aadress;
    private final String telNumber;
    private final String cityName;
}
