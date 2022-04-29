package com.bcs.vanaToit.service.login;

import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
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
    private UserService userService;

    @Resource
    private UserRoleService userRoleService;

    public LoginResponse logIn(LoginRequest request) {
        User user = userService.getValidUser(request);

        LoginResponse loginResponse = new LoginResponse();
        Integer userId = user.getId();
        loginResponse.setUserId(userId);

        List<UserRole> userRoles = userRoleService.getUserRoles(userId);
        List<Integer> userRoleIds = getUserRoleIds(userRoles);
        loginResponse.setUserRoleIds(userRoleIds);
        return loginResponse;
    }

    private List<Integer> getUserRoleIds(List<UserRole> userRoles) {
        List<Integer> userRoleIds = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Integer id = userRole.getId();
            userRoleIds.add(id);
        }
        return userRoleIds;
    }

    public UserResponse addUser(UserRequest request) {
        return userService.addUser(request);

    }
}
