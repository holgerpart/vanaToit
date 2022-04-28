package com.bcs.vanaToit.domain.user.userrole;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserRoleService {

    @Resource
    private UserRoleRepository userRoleRepository;

    public List<UserRole> getUserRoles(Integer userId) {
        return userRoleRepository.findByUserId(userId);
    }
}
