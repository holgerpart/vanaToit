package com.bcs.vanaToit.service.login;

import lombok.Data;

@Data
public class UserRequest {
    private String firstName;
    private String lastName;
    private String name;
    private String password;
    private String role;
}
