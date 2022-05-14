package com.bcs.vanaToit.domain.shop.city;

import lombok.Data;

import java.io.Serializable;

@Data
public class CityDto implements Serializable {
    private final Integer id;
    private final String name;
}
