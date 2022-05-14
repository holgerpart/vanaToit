package com.bcs.vanaToit.service.login;

import com.bcs.vanaToit.domain.shop.city.CityDto;
import com.bcs.vanaToit.domain.shop.city.CityService;
import com.bcs.vanaToit.domain.shop.shop.ShopDto;
import com.bcs.vanaToit.domain.shop.shop.ShopService;
import com.bcs.vanaToit.domain.user.authorized.AuthorizedUserService;
import com.bcs.vanaToit.domain.user.contact.ContactService;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserService;
import com.bcs.vanaToit.domain.user.userrole.UserRole;
import com.bcs.vanaToit.domain.user.userrole.UserRoleService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LoginService {

    @Resource
    public ContactService contactService;

    @Resource
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    @Resource
    private AuthorizedUserService authorizedUserService;

    @Resource
    private ShopService shopService;

    @Resource
    private CityService cityService;

    public LoginResponse logIn(LoginRequest request) {
        User user = userService.getValidUser(request);

        LoginResponse loginResponse = new LoginResponse();
        Integer userId = user.getId();
        loginResponse.setUserId(userId);

        List<UserRole> userRoles = userRoleService.getUserRoles(userId);
        List<LoginRole> loginRoles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            LoginRole loginRole = new LoginRole();
            loginRole.setRoleId(userRole.getRole().getId());
            loginRole.setRoleName(userRole.getRole().getRole());
            loginRoles.add(loginRole);
        }
        loginResponse.setUserRoles(loginRoles);
        return loginResponse;
    }


    public UserResponse addUser(UserRequest request) {
        return userService.addUser(request);

    }

    public void removeContactByName(NameRequest request) {
        contactService.removeContactByName(request);
    }

    public void addShop(ShopRequest request) {
        shopService.addShop(request);
    }

    public List<ShopDto> getShops() {
        return shopService.getShops();
    }

    public void updateShop(ShopDto request) {
        shopService.updateShop(request);
    }

    public List<String> getCities() {
        return cityService.getCities();
    }
}
