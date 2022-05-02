package com.bcs.vanaToit.service.login;

import com.bcs.vanaToit.domain.user.role.Role;
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
        List<String> roleNames = getRoleNames(userRoles);
        loginResponse.setUserRoleIds(userRoleIds);
        loginResponse.setRoleNames(roleNames);
        return loginResponse;
    }

    private List<String> getRoleNames(List<UserRole> userRoles) {
        List<String> roles = new ArrayList<>();
        for (UserRole userRole : userRoles) {
            Role role = userRole.getRole();
            String roleName = role.getRole();
            roles.add(roleName);
        }
        return roles;
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
