package com.bcs.vanaToit.domain.user.authorized;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

@Data
public class AuthorizedUserDto implements Serializable {
    private final Integer shopId;
    private final String shopName;
    private final String city;
}
