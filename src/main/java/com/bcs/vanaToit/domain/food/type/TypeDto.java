package com.bcs.vanaToit.domain.food.type;

import lombok.Data;

import java.io.Serializable;

@Data
public class TypeDto implements Serializable {
    private final Integer id;
    private final String name;
}
