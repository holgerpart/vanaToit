package com.bcs.vanaToit.service.login;

import com.bcs.vanaToit.domain.shop.city.CityDto;
import com.bcs.vanaToit.domain.shop.shop.Shop;
import com.bcs.vanaToit.domain.shop.shop.ShopDto;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/log-in")
public class LoginController {
    @Resource
    private LoginService loginService;

    @PostMapping
    @Operation(summary = "Sisse logimine")
    public LoginResponse logIn(@RequestBody LoginRequest request) {
        return loginService.logIn(request);
    }

    @PostMapping("/user")
    @Operation(summary = "Kasutaja lisamine")
    public UserResponse addUser(@RequestBody UserRequest request) {
        return loginService.addUser(request);
    }

    @DeleteMapping("/user")
    @Operation(summary = "Kontakti eemaldamine")
    public void removeContactByName(@RequestBody NameRequest request) {
        loginService.removeContactByName(request);
    }

    @PostMapping("/shop")
    @Operation(summary = "Poe lisamine")
    public void addShop(@RequestBody ShopRequest request) {
        loginService.addShop(request);
    }

    @PostMapping("/update")
    @Operation(summary = "Poe andmete uuendamine")
    public void updateShop(@RequestBody ShopDto request) {
        loginService.updateShop(request);
    }

    @GetMapping("/all")
    @Operation(summary = "Tagastab poodide nimekirja")
    public List<ShopDto> getShops() {
        return loginService.getShops();
    }

    @GetMapping("/cities")
    @Operation(summary = "Tagastab linnade nimekirja")
    public List<String> getCities() {
        return loginService.getCities();
    }

}
