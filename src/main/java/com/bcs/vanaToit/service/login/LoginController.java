package com.bcs.vanaToit.service.login;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/log-in")
public class LoginController {
    @Resource
    private LoginService loginService;

    public LoginResponse logIn(@RequestBody LoginRequest request) {
        return loginService.logIn(request);
    }

}