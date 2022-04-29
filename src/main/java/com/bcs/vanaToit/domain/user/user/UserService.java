package com.bcs.vanaToit.domain.user.user;

import com.bcs.vanaToit.domain.user.contact.Contact;
import com.bcs.vanaToit.domain.user.contact.ContactService;
import com.bcs.vanaToit.domain.user.role.Role;
import com.bcs.vanaToit.domain.user.role.RoleRepository;
import com.bcs.vanaToit.domain.user.userrole.UserRoleService;
import com.bcs.vanaToit.service.login.LoginRequest;
import com.bcs.vanaToit.service.login.UserRequest;
import com.bcs.vanaToit.service.login.UserResponse;
import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class UserService {
    @Resource
    private UserRepository userRepository;

    @Resource
    private ValidationService validationService;

    @Resource
    private ContactService contactService;

    @Resource
    private RoleRepository roleRepository;

    @Resource
    private UserRoleService userRoleService;

    public User getValidUser(LoginRequest request) {
        Optional<User> user = userRepository.findByNameAndPassword(request.getUserName(), request.getPassword());
        validationService.userNotExists(user);
        return user.get();
    }

    public UserResponse addUser(UserRequest request) {
        validationService.userExists(request);
        Contact contact = contactService.addContact(request);
        User user = new User();
        String username = request.getName();
        user.setName(username);
        user.setPassword(request.getPassword());
        user.setContact(contact);
        userRepository.save(user);
        userRoleService.addUserRole(request);
        UserResponse userResponse = new UserResponse();
        userResponse.setUserName(username);
        userResponse.setRole(request.getRole());
        return userResponse;
    }
}
