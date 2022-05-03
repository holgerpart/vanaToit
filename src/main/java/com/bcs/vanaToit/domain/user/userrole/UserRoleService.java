package com.bcs.vanaToit.domain.user.userrole;

import com.bcs.vanaToit.domain.user.role.Role;
import com.bcs.vanaToit.domain.user.role.RoleRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.service.login.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRepository userRepository;

    public List<UserRole> getUserRoles(Integer userId) {
        return userRoleRepository.findByUserId(userId);
    }

    public void addUserRole(UserRequest request) {
        UserRole userRole = new UserRole();
        userRole.setRole(roleRepository.findByRole(request.getRole()));
        userRole.setUser(userRepository.findByName(request.getName()));
        userRoleRepository.save(userRole);
    }
}
