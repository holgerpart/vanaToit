package com.bcs.vanaToit.domain.user.authorized;

import com.bcs.vanaToit.domain.shop.shop.Shop;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class AuthorizedUserService {

    @Resource
    AuthorizedUserRepository authorizedUserRepository;

    public Shop getShop(Integer userId) {
        AuthorizedUser authorizedUser = authorizedUserRepository.findByUserId(userId);
        Shop shop = authorizedUser.getShop();
        return shop;
    }

    public List<AuthorizedUser> getAuthorizedShops(Integer userId) {
      return  authorizedUserRepository.findUserAuthorizedShops(userId);
    }
}
