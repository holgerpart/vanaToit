package com.bcs.vanaToit.service.login;

import lombok.Data;

import java.util.List;
@Data
public class LoginResponse {
    private Integer userId;
    private List<LoginRole> userRoles;
}
