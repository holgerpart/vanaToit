package com.bcs.vanaToit.domain.food.food;

import com.bcs.vanaToit.service.food.ArticleRequest;
import com.bcs.vanaToit.validation.ValidationService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ArticleService {

    @Resource
    private FoodRepository foodRepository;

    @Resource
    private ValidationService validationService;

    public void addArticle(ArticleRequest request) {
        foodRepository.articleExists(request.getArticleName());
    }

//    public void addA

}
