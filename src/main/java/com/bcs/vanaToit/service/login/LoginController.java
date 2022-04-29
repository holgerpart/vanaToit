package com.bcs.vanaToit.service.login;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log-in")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping
    public LoginResponse logIn(@RequestBody LoginRequest request) {
        return loginService.logIn(request);
    }

    @PostMapping("/user")
    public UserResponse addUser(@RequestBody UserRequest request) {
        return loginService.addUser(request);

    }

}
