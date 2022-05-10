package com.bcs.vanaToit.validation;


import com.bcs.vanaToit.domain.food.food.FoodRepository;
import com.bcs.vanaToit.domain.shop.shop.ShopRepository;
import com.bcs.vanaToit.domain.shopfood.ShopFood;
import com.bcs.vanaToit.domain.shopfood.ShopFoodRepository;
import com.bcs.vanaToit.domain.user.user.User;
import com.bcs.vanaToit.domain.user.user.UserRepository;
import com.bcs.vanaToit.infrastructure.exception.BusinessException;
import com.bcs.vanaToit.service.order.BookFoodRequest;
import com.bcs.vanaToit.service.stock.ArticleRequest;
import com.bcs.vanaToit.service.login.ShopRequest;
import com.bcs.vanaToit.service.login.UserRequest;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Optional;

@Service
public class ValidationService {

    public static final String VIGA_ANDMETES = "Viga andmetes";
    @Resource
    private FoodRepository foodRepository;

    @Resource
    private UserRepository userRepository;

    @Resource
    private ShopRepository shopRepository;

    @Resource
    private ShopFoodRepository shopFoodRepository;

    public static final String ACCOUNT_NOT_EXISTS = "Sellist kontot ei eksisteeri";
    public static final String CUSTOMER_NOT_EXISTS = "Sellist klienti ei eksisteeri";
    public static final String DEPOSIT_OVER_LIMIT = "Deposiidi limiit on ületatud";
    public static final String WITHDRAW_OVER_LIMIT = "Raha väljavõtmise limiit on ületatud";
    public static final String INSUFFICIENT_FUNDS = "Kontol pole piisavalt vahendeid tehingu sooritamiseks";
    public static final String ISIKUKOOD_ALREADY_TAKEN = "Isikukood on kasutusel";

    public void userNotExists(Optional<User> user) {
        if (user.isEmpty()) {
            throw new BusinessException(VIGA_ANDMETES, "Viga kasutajanime või parooli sisetamisel");
        }

    }

    public void userExists(UserRequest request) {
        if (userRepository.existsByName(request.getName())) {
            throw new BusinessException(VIGA_ANDMETES, "Selline kasutajanimi on juba olemas");
        }
    }

    public void articleExists(ArticleRequest request) {
        if(foodRepository.articleExists(request.getArticleName())){
            throw new BusinessException(VIGA_ANDMETES, "See artikkel on juba olemas");
        }
    }

    public void shopExists(ShopRequest request) {
        if (shopRepository.existsByName(request.getShopName())) {
            throw new BusinessException(VIGA_ANDMETES, "See pood on juba olemas");
        }
    }

    public void validQuantity(BookFoodRequest request) {
        Integer quantity = request.getQuantity();
        if (quantity < 1) {
            throw new BusinessException(VIGA_ANDMETES, "Kogus peab olema positiivne");
        }
        Integer remainingQuantity = shopFoodRepository.getById(request.getShopFoodId()).getQuantity();
        if (remainingQuantity < quantity) {
            throw new BusinessException(VIGA_ANDMETES, "Saadaolev kogus ei ole broneerimiseks piisav.");
        }
    }

//    public void accountExists(Integer accountId, Optional<Account> account) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot ID'ga " + accountId + " ei leitud");
//        }
//    }
//
//    public void accountExists(String accountNumber, Optional<Account> account) {
//        if (account.isEmpty()) {
//            throw new DataNotFoundException(ACCOUNT_NOT_EXISTS, "Kontot kontonumbriga " + accountNumber + " ei leitud");
//        }
//    }
//
//    public void isValidDepositAmount(Integer amount) {
//        // productionsis tuleks see väärtus andmebaasist
//        Integer limit = 5000;
//        if (amount > limit) {
//            throw new BusinessException(DEPOSIT_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
//        }
//    }
//
//    public void isValidWithdrawAmount(Integer amount) {
//        // productionsis tuleks see väärtus andmebaasist
//        Integer limit = 15000;
//        if (amount > limit) {
//            throw new BusinessException(WITHDRAW_OVER_LIMIT, "Summa €" + amount + " ületab limiidi €" + limit);
//        }
//    }
//
//    public void isWithinBalance(Integer balance, Integer amount) {
//        if (amount > balance) {
//            throw new BusinessException(INSUFFICIENT_FUNDS, "Summa €" + amount + " ületab kontojääki €" + balance);
//        }
//    }
//
//    public void customerExists(Integer customerId, Optional<Customer> customer) {
//        if (customer.isEmpty()) {
//            throw new DataNotFoundException(CUSTOMER_NOT_EXISTS, "Klienti ID'ga " + customerId + " ei leitud");
//        }
//    }
//
//    public void isikukoodAlreadyExists(String isikukood, boolean customerExists) {
//        if (customerExists) {
//            throw new BusinessException(ISIKUKOOD_ALREADY_TAKEN, "Isikukood " + isikukood + " on juba kasutusel");
//        }
//    }
}
