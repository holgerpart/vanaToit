package com.bcs.vanaToit.domain.user.user;

import com.bcs.vanaToit.service.login.LoginRequest;
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

    public User getValidUser(LoginRequest request) {
        Optional<User> user = userRepository.findByNameAndPassword(request.getUserName(), request.getPassword());
        validationService.userExists(user);
        return user.get();
    }
}
